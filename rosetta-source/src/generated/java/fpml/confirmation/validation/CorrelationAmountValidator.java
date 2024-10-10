package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates;
import fpml.confirmation.Correlation;
import fpml.confirmation.CorrelationAmount;
import fpml.confirmation.DividendsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CorrelationAmountValidator implements Validator<CorrelationAmount> {

	private List<ComparisonResult> getComparisonResults(CorrelationAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationDates", (AdjustableRelativeOrPeriodicDates) o.getCalculationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationStartDate", (AdjustableOrRelativeDate) o.getObservationStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendsModel", (DividendsModel) o.getDividendsModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("correlation", (Correlation) o.getCorrelation() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CorrelationAmount> validate(RosettaPath path, CorrelationAmount o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CorrelationAmount", ValidationType.CARDINALITY, "CorrelationAmount", path, "", error);
		}
		return success("CorrelationAmount", ValidationType.CARDINALITY, "CorrelationAmount", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CorrelationAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CorrelationAmount", ValidationType.CARDINALITY, "CorrelationAmount", path, "", res.getError());
				}
				return success("CorrelationAmount", ValidationType.CARDINALITY, "CorrelationAmount", path, "");
			})
			.collect(toList());
	}

}
