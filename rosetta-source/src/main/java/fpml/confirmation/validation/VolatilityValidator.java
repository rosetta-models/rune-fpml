package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CalculationFromObservationChoice;
import fpml.confirmation.Volatility;
import fpml.confirmation.VolatilityCap;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VolatilityValidator implements Validator<Volatility> {

	private List<ComparisonResult> getComparisonResults(Volatility o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationFromObservationChoice", (CalculationFromObservationChoice) o.getCalculationFromObservationChoice() != null ? 1 : 0, 0, 1), 
				checkCardinality("closingLevel", (Boolean) o.getClosingLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("expiringLevel", (Boolean) o.getExpiringLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("expectedN", (Integer) o.getExpectedN() != null ? 1 : 0, 0, 1), 
				checkCardinality("volatilityCap", (VolatilityCap) o.getVolatilityCap() != null ? 1 : 0, 1, 1), 
				checkCardinality("volatilityStrikePrice", (BigDecimal) o.getVolatilityStrikePrice() != null ? 1 : 0, 1, 1), 
				checkCardinality("vegaNotionalAmount", (BigDecimal) o.getVegaNotionalAmount() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<Volatility> validate(RosettaPath path, Volatility o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Volatility", ValidationType.CARDINALITY, "Volatility", path, "", error);
		}
		return success("Volatility", ValidationType.CARDINALITY, "Volatility", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Volatility o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Volatility", ValidationType.CARDINALITY, "Volatility", path, "", res.getError());
				}
				return success("Volatility", ValidationType.CARDINALITY, "Volatility", path, "");
			})
			.collect(toList());
	}

}
