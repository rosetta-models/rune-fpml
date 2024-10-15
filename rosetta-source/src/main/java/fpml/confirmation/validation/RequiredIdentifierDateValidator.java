package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RequiredIdentifierDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RequiredIdentifierDateValidator implements Validator<RequiredIdentifierDate> {

	private List<ComparisonResult> getComparisonResults(RequiredIdentifierDate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (Date) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<RequiredIdentifierDate> validate(RosettaPath path, RequiredIdentifierDate o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RequiredIdentifierDate", ValidationType.CARDINALITY, "RequiredIdentifierDate", path, "", error);
		}
		return success("RequiredIdentifierDate", ValidationType.CARDINALITY, "RequiredIdentifierDate", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequiredIdentifierDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RequiredIdentifierDate", ValidationType.CARDINALITY, "RequiredIdentifierDate", path, "", res.getError());
				}
				return success("RequiredIdentifierDate", ValidationType.CARDINALITY, "RequiredIdentifierDate", path, "");
			})
			.collect(toList());
	}

}
