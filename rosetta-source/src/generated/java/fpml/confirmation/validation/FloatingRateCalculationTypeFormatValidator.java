package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FloatingRateCalculation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FloatingRateCalculationTypeFormatValidator implements Validator<FloatingRateCalculation> {

	private List<ComparisonResult> getComparisonResults(FloatingRateCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FloatingRateCalculation> validate(RosettaPath path, FloatingRateCalculation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FloatingRateCalculation", ValidationType.TYPE_FORMAT, "FloatingRateCalculation", path, "", error);
		}
		return success("FloatingRateCalculation", ValidationType.TYPE_FORMAT, "FloatingRateCalculation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateCalculation", ValidationType.TYPE_FORMAT, "FloatingRateCalculation", path, "", res.getError());
				}
				return success("FloatingRateCalculation", ValidationType.TYPE_FORMAT, "FloatingRateCalculation", path, "");
			})
			.collect(toList());
	}

}
