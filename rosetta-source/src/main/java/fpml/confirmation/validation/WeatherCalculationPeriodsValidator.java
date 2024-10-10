package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.WeatherCalculationPeriod;
import fpml.confirmation.WeatherCalculationPeriods;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class WeatherCalculationPeriodsValidator implements Validator<WeatherCalculationPeriods> {

	private List<ComparisonResult> getComparisonResults(WeatherCalculationPeriods o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationPeriod", (List<? extends WeatherCalculationPeriod>) o.getCalculationPeriod() == null ? 0 : ((List<? extends WeatherCalculationPeriod>) o.getCalculationPeriod()).size(), 1, 0), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
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
			return failure("WeatherCalculationPeriods", ValidationType.CARDINALITY, "WeatherCalculationPeriods", path, "", error);
		}
		return success("WeatherCalculationPeriods", ValidationType.CARDINALITY, "WeatherCalculationPeriods", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeatherCalculationPeriods o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WeatherCalculationPeriods", ValidationType.CARDINALITY, "WeatherCalculationPeriods", path, "", res.getError());
				}
				return success("WeatherCalculationPeriods", ValidationType.CARDINALITY, "WeatherCalculationPeriods", path, "");
			})
			.collect(toList());
	}

}
