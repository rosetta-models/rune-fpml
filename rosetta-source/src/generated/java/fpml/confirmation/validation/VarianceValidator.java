package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BoundedVariance;
import fpml.confirmation.CalculationFromObservationChoice;
import fpml.confirmation.ExchangeTradedContract;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.Variance;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VarianceValidator implements Validator<Variance> {

	private List<ComparisonResult> getComparisonResults(Variance o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationFromObservationChoice", (CalculationFromObservationChoice) o.getCalculationFromObservationChoice() != null ? 1 : 0, 0, 1), 
				checkCardinality("closingLevel", (Boolean) o.getClosingLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("expiringLevel", (Boolean) o.getExpiringLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("expectedN", (Integer) o.getExpectedN() != null ? 1 : 0, 0, 1), 
				checkCardinality("varianceAmount", (NonNegativeMoney) o.getVarianceAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("volatilityStrikePrice", (BigDecimal) o.getVolatilityStrikePrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("varianceStrikePrice", (BigDecimal) o.getVarianceStrikePrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("varianceCap", (Boolean) o.getVarianceCap() != null ? 1 : 0, 0, 1), 
				checkCardinality("unadjustedVarianceCap", (BigDecimal) o.getUnadjustedVarianceCap() != null ? 1 : 0, 0, 1), 
				checkCardinality("boundedVariance", (BoundedVariance) o.getBoundedVariance() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeTradedContractNearest", (ExchangeTradedContract) o.getExchangeTradedContractNearest() != null ? 1 : 0, 0, 1), 
				checkCardinality("vegaNotionalAmount", (BigDecimal) o.getVegaNotionalAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Variance> validate(RosettaPath path, Variance o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Variance", ValidationType.CARDINALITY, "Variance", path, "", error);
		}
		return success("Variance", ValidationType.CARDINALITY, "Variance", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Variance o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Variance", ValidationType.CARDINALITY, "Variance", path, "", res.getError());
				}
				return success("Variance", ValidationType.CARDINALITY, "Variance", path, "");
			})
			.collect(toList());
	}

}
