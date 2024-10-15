package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.DateList;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanAllocationReference;
import fpml.confirmation.LoanSettlementDateAvailabilityEvent;
import fpml.confirmation.LoanSettlementDateAvailabilityEventSequence;
import fpml.confirmation.Money;
import fpml.confirmation.PeriodModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanSettlementDateAvailabilityEventValidator implements Validator<LoanSettlementDateAvailabilityEvent> {

	private List<ComparisonResult> getComparisonResults(LoanSettlementDateAvailabilityEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("eventIdentifier", (List<? extends BusinessEventIdentifier>) o.getEventIdentifier() == null ? 0 : ((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()).size(), 1, 0), 
				checkCardinality("parentEventIdentifier", (BusinessEventIdentifier) o.getParentEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("correctedEventIdentifier", (BusinessEventIdentifier) o.getCorrectedEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("lenderAndCashDetailsModel", (LenderAndCashDetailsModel) o.getLenderAndCashDetailsModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("comment", (String) o.getComment() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocationReference", (List<? extends LoanAllocationReference>) o.getAllocationReference() == null ? 0 : ((List<? extends LoanAllocationReference>) o.getAllocationReference()).size(), 1, 0), 
				checkCardinality("amount", (List<? extends Money>) o.getAmount() == null ? 0 : ((List<? extends Money>) o.getAmount()).size(), 1, 0), 
				checkCardinality("specificDates", (DateList) o.getSpecificDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("periodModel", (PeriodModel) o.getPeriodModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("onOrAfterDate", (Date) o.getOnOrAfterDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("loanSettlementDateAvailabilityEventSequence", (LoanSettlementDateAvailabilityEventSequence) o.getLoanSettlementDateAvailabilityEventSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LoanSettlementDateAvailabilityEvent> validate(RosettaPath path, LoanSettlementDateAvailabilityEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanSettlementDateAvailabilityEvent", ValidationType.CARDINALITY, "LoanSettlementDateAvailabilityEvent", path, "", error);
		}
		return success("LoanSettlementDateAvailabilityEvent", ValidationType.CARDINALITY, "LoanSettlementDateAvailabilityEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanSettlementDateAvailabilityEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanSettlementDateAvailabilityEvent", ValidationType.CARDINALITY, "LoanSettlementDateAvailabilityEvent", path, "", res.getError());
				}
				return success("LoanSettlementDateAvailabilityEvent", ValidationType.CARDINALITY, "LoanSettlementDateAvailabilityEvent", path, "");
			})
			.collect(toList());
	}

}
