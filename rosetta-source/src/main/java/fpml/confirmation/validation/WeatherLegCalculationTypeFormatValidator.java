package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.WeatherLegCalculation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class WeatherLegCalculationTypeFormatValidator implements Validator<WeatherLegCalculation> {

	private List<ComparisonResult> getComparisonResults(WeatherLegCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<WeatherLegCalculation> validate(RosettaPath path, WeatherLegCalculation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("WeatherLegCalculation", ValidationType.TYPE_FORMAT, "WeatherLegCalculation", path, "", error);
		}
		return success("WeatherLegCalculation", ValidationType.TYPE_FORMAT, "WeatherLegCalculation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeatherLegCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WeatherLegCalculation", ValidationType.TYPE_FORMAT, "WeatherLegCalculation", path, "", res.getError());
				}
				return success("WeatherLegCalculation", ValidationType.TYPE_FORMAT, "WeatherLegCalculation", path, "");
			})
			.collect(toList());
	}

}
