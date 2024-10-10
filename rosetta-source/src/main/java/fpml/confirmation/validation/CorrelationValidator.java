package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BoundedCorrelation;
import fpml.confirmation.CalculationFromObservationChoice;
import fpml.confirmation.Correlation;
import fpml.confirmation.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CorrelationValidator implements Validator<Correlation> {

	private List<ComparisonResult> getComparisonResults(Correlation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationFromObservationChoice", (CalculationFromObservationChoice) o.getCalculationFromObservationChoice() != null ? 1 : 0, 0, 1), 
				checkCardinality("closingLevel", (Boolean) o.getClosingLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("expiringLevel", (Boolean) o.getExpiringLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("expectedN", (Integer) o.getExpectedN() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmount", (NonNegativeMoney) o.getNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("correlationStrikePrice", (BigDecimal) o.getCorrelationStrikePrice() != null ? 1 : 0, 1, 1), 
				checkCardinality("boundedCorrelation", (BoundedCorrelation) o.getBoundedCorrelation() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfDataSeries", (Integer) o.getNumberOfDataSeries() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Correlation> validate(RosettaPath path, Correlation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Correlation", ValidationType.CARDINALITY, "Correlation", path, "", error);
		}
		return success("Correlation", ValidationType.CARDINALITY, "Correlation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Correlation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Correlation", ValidationType.CARDINALITY, "Correlation", path, "", res.getError());
				}
				return success("Correlation", ValidationType.CARDINALITY, "Correlation", path, "");
			})
			.collect(toList());
	}

}
