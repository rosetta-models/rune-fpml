package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates2;
import fpml.confirmation.InterestLegCalculationPeriodDates;
import fpml.confirmation.InterestLegResetDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InterestLegCalculationPeriodDatesValidator implements Validator<InterestLegCalculationPeriodDates> {

	private List<ComparisonResult> getComparisonResults(InterestLegCalculationPeriodDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("terminationDate", (AdjustableOrRelativeDate) o.getTerminationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("interestLegResetDates", (InterestLegResetDates) o.getInterestLegResetDates() != null ? 1 : 0, 1, 1), 
				checkCardinality("interestLegPaymentDates", (AdjustableRelativeOrPeriodicDates2) o.getInterestLegPaymentDates() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<InterestLegCalculationPeriodDates> validate(RosettaPath path, InterestLegCalculationPeriodDates o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InterestLegCalculationPeriodDates", ValidationType.CARDINALITY, "InterestLegCalculationPeriodDates", path, "", error);
		}
		return success("InterestLegCalculationPeriodDates", ValidationType.CARDINALITY, "InterestLegCalculationPeriodDates", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestLegCalculationPeriodDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestLegCalculationPeriodDates", ValidationType.CARDINALITY, "InterestLegCalculationPeriodDates", path, "", res.getError());
				}
				return success("InterestLegCalculationPeriodDates", ValidationType.CARDINALITY, "InterestLegCalculationPeriodDates", path, "");
			})
			.collect(toList());
	}

}
