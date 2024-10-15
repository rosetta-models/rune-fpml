package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.StrategyComponentIdentification;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StrategyComponentIdentificationTypeFormatValidator implements Validator<StrategyComponentIdentification> {

	private List<ComparisonResult> getComparisonResults(StrategyComponentIdentification o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<StrategyComponentIdentification> validate(RosettaPath path, StrategyComponentIdentification o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("StrategyComponentIdentification", ValidationType.TYPE_FORMAT, "StrategyComponentIdentification", path, "", error);
		}
		return success("StrategyComponentIdentification", ValidationType.TYPE_FORMAT, "StrategyComponentIdentification", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StrategyComponentIdentification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StrategyComponentIdentification", ValidationType.TYPE_FORMAT, "StrategyComponentIdentification", path, "", res.getError());
				}
				return success("StrategyComponentIdentification", ValidationType.TYPE_FORMAT, "StrategyComponentIdentification", path, "");
			})
			.collect(toList());
	}

}
