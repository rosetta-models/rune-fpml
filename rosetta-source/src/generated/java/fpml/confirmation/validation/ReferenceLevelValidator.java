package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReferenceLevel;
import fpml.confirmation.ReferenceLevelUnit;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReferenceLevelValidator implements Validator<ReferenceLevel> {

	private List<ComparisonResult> getComparisonResults(ReferenceLevel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("amount", (BigDecimal) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("referenceLevelUnit", (ReferenceLevelUnit) o.getReferenceLevelUnit() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<ReferenceLevel> validate(RosettaPath path, ReferenceLevel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReferenceLevel", ValidationType.CARDINALITY, "ReferenceLevel", path, "", error);
		}
		return success("ReferenceLevel", ValidationType.CARDINALITY, "ReferenceLevel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceLevel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferenceLevel", ValidationType.CARDINALITY, "ReferenceLevel", path, "", res.getError());
				}
				return success("ReferenceLevel", ValidationType.CARDINALITY, "ReferenceLevel", path, "");
			})
			.collect(toList());
	}

}
