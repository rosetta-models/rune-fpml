package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.WeatherCalculationPeriods;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class WeatherCalculationPeriodsTypeFormatValidator implements Validator<WeatherCalculationPeriods> {

	private List<ComparisonResult> getComparisonResults(WeatherCalculationPeriods o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<WeatherCalculationPeriods> validate(RosettaPath path, WeatherCalculationPeriods o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("WeatherCalculationPeriods", ValidationType.TYPE_FORMAT, "WeatherCalculationPeriods", path, "", error);
		}
		return success("WeatherCalculationPeriods", ValidationType.TYPE_FORMAT, "WeatherCalculationPeriods", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeatherCalculationPeriods o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WeatherCalculationPeriods", ValidationType.TYPE_FORMAT, "WeatherCalculationPeriods", path, "", res.getError());
				}
				return success("WeatherCalculationPeriods", ValidationType.TYPE_FORMAT, "WeatherCalculationPeriods", path, "");
			})
			.collect(toList());
	}

}
