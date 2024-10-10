package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanTradeReference;
import fpml.confirmation.LoanTradeTransferFeeOwedEvent;
import fpml.confirmation.LoanTradingTransferFeeDeterminationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradeTransferFeeOwedEventValidator implements Validator<LoanTradeTransferFeeOwedEvent> {

	private List<ComparisonResult> getComparisonResults(LoanTradeTransferFeeOwedEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("eventIdentifier", (List<? extends BusinessEventIdentifier>) o.getEventIdentifier() == null ? 0 : ((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()).size(), 1, 0), 
				checkCardinality("parentEventIdentifier", (BusinessEventIdentifier) o.getParentEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("correctedEventIdentifier", (BusinessEventIdentifier) o.getCorrectedEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("lenderAndCashDetailsModel", (LenderAndCashDetailsModel) o.getLenderAndCashDetailsModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("comment", (String) o.getComment() != null ? 1 : 0, 0, 1), 
				checkCardinality("loanTradeReference", (LoanTradeReference) o.getLoanTradeReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("loanTradingTransferFeeDeterminationModel", (LoanTradingTransferFeeDeterminationModel) o.getLoanTradingTransferFeeDeterminationModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<LoanTradeTransferFeeOwedEvent> validate(RosettaPath path, LoanTradeTransferFeeOwedEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradeTransferFeeOwedEvent", ValidationType.CARDINALITY, "LoanTradeTransferFeeOwedEvent", path, "", error);
		}
		return success("LoanTradeTransferFeeOwedEvent", ValidationType.CARDINALITY, "LoanTradeTransferFeeOwedEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradeTransferFeeOwedEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradeTransferFeeOwedEvent", ValidationType.CARDINALITY, "LoanTradeTransferFeeOwedEvent", path, "", res.getError());
				}
				return success("LoanTradeTransferFeeOwedEvent", ValidationType.CARDINALITY, "LoanTradeTransferFeeOwedEvent", path, "");
			})
			.collect(toList());
	}

}
