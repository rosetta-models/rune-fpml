package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccrualPeriod;
import fpml.confirmation.AccrualReferenceAmountTypeEnum;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.PeriodWithDaysModel;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AccrualPeriodValidator implements Validator<AccrualPeriod> {

	private List<ComparisonResult> getComparisonResults(AccrualPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("periodWithDaysModel", (PeriodWithDaysModel) o.getPeriodWithDaysModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("referenceAmount", (MoneyWithParticipantShare) o.getReferenceAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("referenceAmountType", (AccrualReferenceAmountTypeEnum) o.getReferenceAmountType() != null ? 1 : 0, 0, 1), 
				checkCardinality("rate", (BigDecimal) o.getRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("accrualAmount", (MoneyWithParticipantShare) o.getAccrualAmount() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<AccrualPeriod> validate(RosettaPath path, AccrualPeriod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AccrualPeriod", ValidationType.CARDINALITY, "AccrualPeriod", path, "", error);
		}
		return success("AccrualPeriod", ValidationType.CARDINALITY, "AccrualPeriod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccrualPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AccrualPeriod", ValidationType.CARDINALITY, "AccrualPeriod", path, "", res.getError());
				}
				return success("AccrualPeriod", ValidationType.CARDINALITY, "AccrualPeriod", path, "");
			})
			.collect(toList());
	}

}
