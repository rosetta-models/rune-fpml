package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NotionalStepRule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NotionalStepRuleTypeFormatValidator implements Validator<NotionalStepRule> {

	private List<ComparisonResult> getComparisonResults(NotionalStepRule o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<NotionalStepRule> validate(RosettaPath path, NotionalStepRule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NotionalStepRule", ValidationType.TYPE_FORMAT, "NotionalStepRule", path, "", error);
		}
		return success("NotionalStepRule", ValidationType.TYPE_FORMAT, "NotionalStepRule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotionalStepRule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NotionalStepRule", ValidationType.TYPE_FORMAT, "NotionalStepRule", path, "", res.getError());
				}
				return success("NotionalStepRule", ValidationType.TYPE_FORMAT, "NotionalStepRule", path, "");
			})
			.collect(toList());
	}

}
