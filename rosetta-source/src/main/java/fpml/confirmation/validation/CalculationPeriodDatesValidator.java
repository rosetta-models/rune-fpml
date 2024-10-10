package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.AdjustedRelativeDateOffset;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.CalculationPeriodDates;
import fpml.confirmation.CalculationPeriodFrequency;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.StubPeriodTypeEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CalculationPeriodDatesValidator implements Validator<CalculationPeriodDates> {

	private List<ComparisonResult> getComparisonResults(CalculationPeriodDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("effectiveDate", (AdjustableDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativeEffectiveDate", (AdjustedRelativeDateOffset) o.getRelativeEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminationDate", (AdjustableDate) o.getTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativeTerminationDate", (RelativeDateOffset) o.getRelativeTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodDatesAdjustments", (BusinessDayAdjustments) o.getCalculationPeriodDatesAdjustments() != null ? 1 : 0, 1, 1), 
				checkCardinality("firstPeriodStartDate", (AdjustableDate) o.getFirstPeriodStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("firstRegularPeriodStartDate", (Date) o.getFirstRegularPeriodStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("firstCompoundingPeriodEndDate", (Date) o.getFirstCompoundingPeriodEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("lastRegularPeriodEndDate", (Date) o.getLastRegularPeriodEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("stubPeriodType", (StubPeriodTypeEnum) o.getStubPeriodType() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodFrequency", (CalculationPeriodFrequency) o.getCalculationPeriodFrequency() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CalculationPeriodDates> validate(RosettaPath path, CalculationPeriodDates o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CalculationPeriodDates", ValidationType.CARDINALITY, "CalculationPeriodDates", path, "", error);
		}
		return success("CalculationPeriodDates", ValidationType.CARDINALITY, "CalculationPeriodDates", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationPeriodDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationPeriodDates", ValidationType.CARDINALITY, "CalculationPeriodDates", path, "", res.getError());
				}
				return success("CalculationPeriodDates", ValidationType.CARDINALITY, "CalculationPeriodDates", path, "");
			})
			.collect(toList());
	}

}
