package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanAllocationReference;
import fpml.confirmation.LoanAllocationTransferFeeOwedEvent;
import fpml.confirmation.LoanTradingTransferFeeDeterminationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanAllocationTransferFeeOwedEventValidator implements Validator<LoanAllocationTransferFeeOwedEvent> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationTransferFeeOwedEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("eventIdentifier", (List<? extends BusinessEventIdentifier>) o.getEventIdentifier() == null ? 0 : ((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()).size(), 1, 0), 
				checkCardinality("parentEventIdentifier", (BusinessEventIdentifier) o.getParentEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("correctedEventIdentifier", (BusinessEventIdentifier) o.getCorrectedEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("lenderAndCashDetailsModel", (LenderAndCashDetailsModel) o.getLenderAndCashDetailsModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("comment", (String) o.getComment() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocationReference", (List<? extends LoanAllocationReference>) o.getAllocationReference() == null ? 0 : ((List<? extends LoanAllocationReference>) o.getAllocationReference()).size(), 1, 0), 
				checkCardinality("loanTradingTransferFeeDeterminationModel", (LoanTradingTransferFeeDeterminationModel) o.getLoanTradingTransferFeeDeterminationModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<LoanAllocationTransferFeeOwedEvent> validate(RosettaPath path, LoanAllocationTransferFeeOwedEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanAllocationTransferFeeOwedEvent", ValidationType.CARDINALITY, "LoanAllocationTransferFeeOwedEvent", path, "", error);
		}
		return success("LoanAllocationTransferFeeOwedEvent", ValidationType.CARDINALITY, "LoanAllocationTransferFeeOwedEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationTransferFeeOwedEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationTransferFeeOwedEvent", ValidationType.CARDINALITY, "LoanAllocationTransferFeeOwedEvent", path, "", res.getError());
				}
				return success("LoanAllocationTransferFeeOwedEvent", ValidationType.CARDINALITY, "LoanAllocationTransferFeeOwedEvent", path, "");
			})
			.collect(toList());
	}

}
