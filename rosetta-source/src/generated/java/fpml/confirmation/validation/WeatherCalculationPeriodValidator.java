package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.WeatherCalculationPeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class WeatherCalculationPeriodValidator implements Validator<WeatherCalculationPeriod> {

	private List<ComparisonResult> getComparisonResults(WeatherCalculationPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationPeriodFirstDay", (IdentifiedDate) o.getCalculationPeriodFirstDay() != null ? 1 : 0, 1, 1), 
				checkCardinality("calculationPeriodEndDay", (IdentifiedDate) o.getCalculationPeriodEndDay() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<WeatherCalculationPeriod> validate(RosettaPath path, WeatherCalculationPeriod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("WeatherCalculationPeriod", ValidationType.CARDINALITY, "WeatherCalculationPeriod", path, "", error);
		}
		return success("WeatherCalculationPeriod", ValidationType.CARDINALITY, "WeatherCalculationPeriod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeatherCalculationPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WeatherCalculationPeriod", ValidationType.CARDINALITY, "WeatherCalculationPeriod", path, "", res.getError());
				}
				return success("WeatherCalculationPeriod", ValidationType.CARDINALITY, "WeatherCalculationPeriod", path, "");
			})
			.collect(toList());
	}

}
