package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccrualTypeId;
import fpml.confirmation.AccruingFeeOption;
import fpml.confirmation.AccruingFeeType;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.Period;
import fpml.confirmation.PeriodOptionalEndModel;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AccruingFeeOptionValidator implements Validator<AccruingFeeOption> {

	private List<ComparisonResult> getComparisonResults(AccruingFeeOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("accrualOptionId", (AccrualTypeId) o.getAccrualOptionId() != null ? 1 : 0, 1, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentFrequency", (Period) o.getPaymentFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("rate", (BigDecimal) o.getRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("_type", (AccruingFeeType) o.get_type() != null ? 1 : 0, 1, 1), 
				checkCardinality("periodOptionalEndModel", (PeriodOptionalEndModel) o.getPeriodOptionalEndModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("calculationDefinition", (String) o.getCalculationDefinition() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<AccruingFeeOption> validate(RosettaPath path, AccruingFeeOption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AccruingFeeOption", ValidationType.CARDINALITY, "AccruingFeeOption", path, "", error);
		}
		return success("AccruingFeeOption", ValidationType.CARDINALITY, "AccruingFeeOption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccruingFeeOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AccruingFeeOption", ValidationType.CARDINALITY, "AccruingFeeOption", path, "", res.getError());
				}
				return success("AccruingFeeOption", ValidationType.CARDINALITY, "AccruingFeeOption", path, "");
			})
			.collect(toList());
	}

}
