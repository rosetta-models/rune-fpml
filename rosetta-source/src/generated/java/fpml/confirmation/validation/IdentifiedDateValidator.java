package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IdentifiedDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class IdentifiedDateValidator implements Validator<IdentifiedDate> {

	private List<ComparisonResult> getComparisonResults(IdentifiedDate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (Date) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<IdentifiedDate> validate(RosettaPath path, IdentifiedDate o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("IdentifiedDate", ValidationType.CARDINALITY, "IdentifiedDate", path, "", error);
		}
		return success("IdentifiedDate", ValidationType.CARDINALITY, "IdentifiedDate", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IdentifiedDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IdentifiedDate", ValidationType.CARDINALITY, "IdentifiedDate", path, "", res.getError());
				}
				return success("IdentifiedDate", ValidationType.CARDINALITY, "IdentifiedDate", path, "");
			})
			.collect(toList());
	}

}
