package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.CalculationPeriodFrequency;
import fpml.confirmation.PeriodicDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PeriodicDatesValidator implements Validator<PeriodicDates> {

	private List<ComparisonResult> getComparisonResults(PeriodicDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationStartDate", (AdjustableOrRelativeDate) o.getCalculationStartDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("calculationEndDate", (AdjustableOrRelativeDate) o.getCalculationEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodFrequency", (CalculationPeriodFrequency) o.getCalculationPeriodFrequency() != null ? 1 : 0, 1, 1), 
				checkCardinality("calculationPeriodDatesAdjustments", (BusinessDayAdjustments) o.getCalculationPeriodDatesAdjustments() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<PeriodicDates> validate(RosettaPath path, PeriodicDates o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PeriodicDates", ValidationType.CARDINALITY, "PeriodicDates", path, "", error);
		}
		return success("PeriodicDates", ValidationType.CARDINALITY, "PeriodicDates", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PeriodicDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PeriodicDates", ValidationType.CARDINALITY, "PeriodicDates", path, "", res.getError());
				}
				return success("PeriodicDates", ValidationType.CARDINALITY, "PeriodicDates", path, "");
			})
			.collect(toList());
	}

}
