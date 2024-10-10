package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CalculationPeriodsReference;
import fpml.confirmation.WeatherCalculationPeriodModel;
import fpml.confirmation.WeatherCalculationPeriods;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class WeatherCalculationPeriodModelValidator implements Validator<WeatherCalculationPeriodModel> {

	private List<ComparisonResult> getComparisonResults(WeatherCalculationPeriodModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("weatherCalculationPeriods", (WeatherCalculationPeriods) o.getWeatherCalculationPeriods() != null ? 1 : 0, 0, 1), 
				checkCardinality("weatherCalculationPeriodsReference", (CalculationPeriodsReference) o.getWeatherCalculationPeriodsReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<WeatherCalculationPeriodModel> validate(RosettaPath path, WeatherCalculationPeriodModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("WeatherCalculationPeriodModel", ValidationType.CARDINALITY, "WeatherCalculationPeriodModel", path, "", error);
		}
		return success("WeatherCalculationPeriodModel", ValidationType.CARDINALITY, "WeatherCalculationPeriodModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeatherCalculationPeriodModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WeatherCalculationPeriodModel", ValidationType.CARDINALITY, "WeatherCalculationPeriodModel", path, "", res.getError());
				}
				return success("WeatherCalculationPeriodModel", ValidationType.CARDINALITY, "WeatherCalculationPeriodModel", path, "");
			})
			.collect(toList());
	}

}
