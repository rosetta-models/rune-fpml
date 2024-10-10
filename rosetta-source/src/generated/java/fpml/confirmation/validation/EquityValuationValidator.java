package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableDateOrRelativeDateSequence;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.EquityValuation;
import fpml.confirmation.FPVFinalPriceElectionFallbackEnum;
import fpml.confirmation.TimeTypeEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquityValuationValidator implements Validator<EquityValuation> {

	private List<ComparisonResult> getComparisonResults(EquityValuation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("valuationDate", (AdjustableDateOrRelativeDateSequence) o.getValuationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationDates", (AdjustableRelativeOrPeriodicDates) o.getValuationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationTimeType", (TimeTypeEnum) o.getValuationTimeType() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationTime", (BusinessCenterTime) o.getValuationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("futuresPriceValuation", (Boolean) o.getFuturesPriceValuation() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionsPriceValuation", (Boolean) o.getOptionsPriceValuation() != null ? 1 : 0, 0, 1), 
				checkCardinality("numberOfValuationDates", (Integer) o.getNumberOfValuationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendValuationDates", (AdjustableRelativeOrPeriodicDates) o.getDividendValuationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("fPVFinalPriceElectionFallback", (FPVFinalPriceElectionFallbackEnum) o.getFPVFinalPriceElectionFallback() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<EquityValuation> validate(RosettaPath path, EquityValuation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquityValuation", ValidationType.CARDINALITY, "EquityValuation", path, "", error);
		}
		return success("EquityValuation", ValidationType.CARDINALITY, "EquityValuation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityValuation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityValuation", ValidationType.CARDINALITY, "EquityValuation", path, "", res.getError());
				}
				return success("EquityValuation", ValidationType.CARDINALITY, "EquityValuation", path, "");
			})
			.collect(toList());
	}

}
