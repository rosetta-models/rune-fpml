package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InterestAccrualsMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InterestAccrualsMethodTypeFormatValidator implements Validator<InterestAccrualsMethod> {

	private List<ComparisonResult> getComparisonResults(InterestAccrualsMethod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<InterestAccrualsMethod> validate(RosettaPath path, InterestAccrualsMethod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InterestAccrualsMethod", ValidationType.TYPE_FORMAT, "InterestAccrualsMethod", path, "", error);
		}
		return success("InterestAccrualsMethod", ValidationType.TYPE_FORMAT, "InterestAccrualsMethod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestAccrualsMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestAccrualsMethod", ValidationType.TYPE_FORMAT, "InterestAccrualsMethod", path, "", res.getError());
				}
				return success("InterestAccrualsMethod", ValidationType.TYPE_FORMAT, "InterestAccrualsMethod", path, "");
			})
			.collect(toList());
	}

}
