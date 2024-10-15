package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccrualTypeId;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.LcOption;
import fpml.confirmation.LcType;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.Period;
import fpml.confirmation.PeriodModel;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LcOptionValidator implements Validator<LcOption> {

	private List<ComparisonResult> getComparisonResults(LcOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("accrualOptionId", (AccrualTypeId) o.getAccrualOptionId() != null ? 1 : 0, 1, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentFrequency", (Period) o.getPaymentFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("rate", (BigDecimal) o.getRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("periodModel", (PeriodModel) o.getPeriodModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("_type", (LcType) o.get_type() != null ? 1 : 0, 1, 1), 
				checkCardinality("minLcIssuanceFeeAmount", (MoneyWithParticipantShare) o.getMinLcIssuanceFeeAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LcOption> validate(RosettaPath path, LcOption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LcOption", ValidationType.CARDINALITY, "LcOption", path, "", error);
		}
		return success("LcOption", ValidationType.CARDINALITY, "LcOption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LcOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LcOption", ValidationType.CARDINALITY, "LcOption", path, "", res.getError());
				}
				return success("LcOption", ValidationType.CARDINALITY, "LcOption", path, "");
			})
			.collect(toList());
	}

}
