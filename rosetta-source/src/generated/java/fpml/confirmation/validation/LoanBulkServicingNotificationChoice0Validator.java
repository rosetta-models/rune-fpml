package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbstractFacilityEvent;
import fpml.confirmation.AbstractLcEvent;
import fpml.confirmation.AbstractLoanContractEvent;
import fpml.confirmation.AccruingFeePayment;
import fpml.confirmation.AccruingPikPayment;
import fpml.confirmation.LoanBulkServicingNotificationChoice0;
import fpml.confirmation.NonRecurringFeePayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanBulkServicingNotificationChoice0Validator implements Validator<LoanBulkServicingNotificationChoice0> {

	private List<ComparisonResult> getComparisonResults(LoanBulkServicingNotificationChoice0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("facilityFeePaymentGroup", (NonRecurringFeePayment) o.getFacilityFeePaymentGroup() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilityEventGroup", (AbstractFacilityEvent) o.getFacilityEventGroup() != null ? 1 : 0, 0, 1), 
				checkCardinality("accruingFeePayment", (AccruingFeePayment) o.getAccruingFeePayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("accruingPikPayment", (AccruingPikPayment) o.getAccruingPikPayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("loanContractEventGroup", (AbstractLoanContractEvent) o.getLoanContractEventGroup() != null ? 1 : 0, 0, 1), 
				checkCardinality("lcEventGroup", (AbstractLcEvent) o.getLcEventGroup() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LoanBulkServicingNotificationChoice0> validate(RosettaPath path, LoanBulkServicingNotificationChoice0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanBulkServicingNotificationChoice0", ValidationType.CARDINALITY, "LoanBulkServicingNotificationChoice0", path, "", error);
		}
		return success("LoanBulkServicingNotificationChoice0", ValidationType.CARDINALITY, "LoanBulkServicingNotificationChoice0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanBulkServicingNotificationChoice0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanBulkServicingNotificationChoice0", ValidationType.CARDINALITY, "LoanBulkServicingNotificationChoice0", path, "", res.getError());
				}
				return success("LoanBulkServicingNotificationChoice0", ValidationType.CARDINALITY, "LoanBulkServicingNotificationChoice0", path, "");
			})
			.collect(toList());
	}

}
