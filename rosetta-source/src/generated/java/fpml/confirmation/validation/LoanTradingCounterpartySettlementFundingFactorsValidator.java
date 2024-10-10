package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuyerSellerAmounts;
import fpml.confirmation.LoanTradingCounterpartySettlementFundingFactors;
import fpml.confirmation.LoanTradingCounterpartySettlementFundingFactorsSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradingCounterpartySettlementFundingFactorsValidator implements Validator<LoanTradingCounterpartySettlementFundingFactors> {

	private List<ComparisonResult> getComparisonResults(LoanTradingCounterpartySettlementFundingFactors o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("loanTradingCounterpartySettlementFundingFactorsSequence", (LoanTradingCounterpartySettlementFundingFactorsSequence) o.getLoanTradingCounterpartySettlementFundingFactorsSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("transferFeeAmounts", (BuyerSellerAmounts) o.getTransferFeeAmounts() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<LoanTradingCounterpartySettlementFundingFactors> validate(RosettaPath path, LoanTradingCounterpartySettlementFundingFactors o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradingCounterpartySettlementFundingFactors", ValidationType.CARDINALITY, "LoanTradingCounterpartySettlementFundingFactors", path, "", error);
		}
		return success("LoanTradingCounterpartySettlementFundingFactors", ValidationType.CARDINALITY, "LoanTradingCounterpartySettlementFundingFactors", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingCounterpartySettlementFundingFactors o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingCounterpartySettlementFundingFactors", ValidationType.CARDINALITY, "LoanTradingCounterpartySettlementFundingFactors", path, "", res.getError());
				}
				return success("LoanTradingCounterpartySettlementFundingFactors", ValidationType.CARDINALITY, "LoanTradingCounterpartySettlementFundingFactors", path, "");
			})
			.collect(toList());
	}

}
