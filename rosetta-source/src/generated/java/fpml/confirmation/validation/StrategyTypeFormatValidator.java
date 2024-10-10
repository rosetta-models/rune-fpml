package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Strategy;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StrategyTypeFormatValidator implements Validator<Strategy> {

	private List<ComparisonResult> getComparisonResults(Strategy o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Strategy> validate(RosettaPath path, Strategy o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Strategy", ValidationType.TYPE_FORMAT, "Strategy", path, "", error);
		}
		return success("Strategy", ValidationType.TYPE_FORMAT, "Strategy", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Strategy o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Strategy", ValidationType.TYPE_FORMAT, "Strategy", path, "", res.getError());
				}
				return success("Strategy", ValidationType.TYPE_FORMAT, "Strategy", path, "");
			})
			.collect(toList());
	}

}
