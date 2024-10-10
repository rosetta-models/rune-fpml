package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.FacilityOutstandingsPosition;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanAllocationReference;
import fpml.confirmation.LoanTransferSettlementEvent;
import fpml.confirmation.Money;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTransferSettlementEventValidator implements Validator<LoanTransferSettlementEvent> {

	private List<ComparisonResult> getComparisonResults(LoanTransferSettlementEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("eventIdentifier", (List<? extends BusinessEventIdentifier>) o.getEventIdentifier() == null ? 0 : ((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()).size(), 1, 0), 
				checkCardinality("parentEventIdentifier", (BusinessEventIdentifier) o.getParentEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("correctedEventIdentifier", (BusinessEventIdentifier) o.getCorrectedEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("lenderAndCashDetailsModel", (LenderAndCashDetailsModel) o.getLenderAndCashDetailsModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("comment", (String) o.getComment() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocationReference", (LoanAllocationReference) o.getAllocationReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementDate", (Date) o.getSettlementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("amount", (Money) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("facilityOutstandingsPosition", (FacilityOutstandingsPosition) o.getFacilityOutstandingsPosition() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<LoanTransferSettlementEvent> validate(RosettaPath path, LoanTransferSettlementEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTransferSettlementEvent", ValidationType.CARDINALITY, "LoanTransferSettlementEvent", path, "", error);
		}
		return success("LoanTransferSettlementEvent", ValidationType.CARDINALITY, "LoanTransferSettlementEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTransferSettlementEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTransferSettlementEvent", ValidationType.CARDINALITY, "LoanTransferSettlementEvent", path, "", res.getError());
				}
				return success("LoanTransferSettlementEvent", ValidationType.CARDINALITY, "LoanTransferSettlementEvent", path, "");
			})
			.collect(toList());
	}

}
