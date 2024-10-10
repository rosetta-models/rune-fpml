package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReferenceAmount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReferenceAmountValidator implements Validator<ReferenceAmount> {

	private List<ComparisonResult> getComparisonResults(ReferenceAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("referenceAmountScheme", (String) o.getReferenceAmountScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ReferenceAmount> validate(RosettaPath path, ReferenceAmount o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReferenceAmount", ValidationType.CARDINALITY, "ReferenceAmount", path, "", error);
		}
		return success("ReferenceAmount", ValidationType.CARDINALITY, "ReferenceAmount", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferenceAmount", ValidationType.CARDINALITY, "ReferenceAmount", path, "", res.getError());
				}
				return success("ReferenceAmount", ValidationType.CARDINALITY, "ReferenceAmount", path, "");
			})
			.collect(toList());
	}

}
