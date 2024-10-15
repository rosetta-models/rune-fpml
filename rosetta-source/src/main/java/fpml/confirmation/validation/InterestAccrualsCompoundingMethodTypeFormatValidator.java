package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InterestAccrualsCompoundingMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InterestAccrualsCompoundingMethodTypeFormatValidator implements Validator<InterestAccrualsCompoundingMethod> {

	private List<ComparisonResult> getComparisonResults(InterestAccrualsCompoundingMethod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<InterestAccrualsCompoundingMethod> validate(RosettaPath path, InterestAccrualsCompoundingMethod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InterestAccrualsCompoundingMethod", ValidationType.TYPE_FORMAT, "InterestAccrualsCompoundingMethod", path, "", error);
		}
		return success("InterestAccrualsCompoundingMethod", ValidationType.TYPE_FORMAT, "InterestAccrualsCompoundingMethod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestAccrualsCompoundingMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestAccrualsCompoundingMethod", ValidationType.TYPE_FORMAT, "InterestAccrualsCompoundingMethod", path, "", res.getError());
				}
				return success("InterestAccrualsCompoundingMethod", ValidationType.TYPE_FORMAT, "InterestAccrualsCompoundingMethod", path, "");
			})
			.collect(toList());
	}

}
