package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates;
import fpml.confirmation.DividendsModel;
import fpml.confirmation.Volatility;
import fpml.confirmation.VolatilityAmount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VolatilityAmountValidator implements Validator<VolatilityAmount> {

	private List<ComparisonResult> getComparisonResults(VolatilityAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationDates", (AdjustableRelativeOrPeriodicDates) o.getCalculationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationStartDate", (AdjustableOrRelativeDate) o.getObservationStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendsModel", (DividendsModel) o.getDividendsModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("volatility", (Volatility) o.getVolatility() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<VolatilityAmount> validate(RosettaPath path, VolatilityAmount o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VolatilityAmount", ValidationType.CARDINALITY, "VolatilityAmount", path, "", error);
		}
		return success("VolatilityAmount", ValidationType.CARDINALITY, "VolatilityAmount", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilityAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VolatilityAmount", ValidationType.CARDINALITY, "VolatilityAmount", path, "", res.getError());
				}
				return success("VolatilityAmount", ValidationType.CARDINALITY, "VolatilityAmount", path, "");
			})
			.collect(toList());
	}

}
