package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LoanTrade;
import fpml.confirmation.LoanTradingCounterpartyCashSettlementRulesModel;
import fpml.confirmation.LoanTradingParticipationSettlementTermsModel;
import fpml.confirmation.LoanTradingSettlementTermsModel;
import fpml.confirmation.LoanTradingTypeEnum;
import fpml.confirmation.LoanTransferFee;
import fpml.confirmation.Money;
import fpml.confirmation.TradeIdentifier;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradeValidator implements Validator<LoanTrade> {

	private List<ComparisonResult> getComparisonResults(LoanTrade o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeIdentifier", (TradeIdentifier) o.getTradeIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("facilityReference", (FacilityReference) o.getFacilityReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("amount", (Money) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("comment", (String) o.getComment() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeDate", (Date) o.getTradeDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("type", (LoanTradingTypeEnum) o.getType_() != null ? 1 : 0, 1, 1), 
				checkCardinality("whenIssuedFlag", (Boolean) o.getWhenIssuedFlag() != null ? 1 : 0, 1, 1), 
				checkCardinality("loanTradingSettlementTermsModel", (LoanTradingSettlementTermsModel) o.getLoanTradingSettlementTermsModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("price", (BigDecimal) o.getPrice() != null ? 1 : 0, 1, 1), 
				checkCardinality("transferFee", (LoanTransferFee) o.getTransferFee() != null ? 1 : 0, 1, 1), 
				checkCardinality("loanTradingCounterpartyCashSettlementRulesModel", (LoanTradingCounterpartyCashSettlementRulesModel) o.getLoanTradingCounterpartyCashSettlementRulesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("loanTradingParticipationSettlementTermsModel", (LoanTradingParticipationSettlementTermsModel) o.getLoanTradingParticipationSettlementTermsModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LoanTrade> validate(RosettaPath path, LoanTrade o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTrade", ValidationType.CARDINALITY, "LoanTrade", path, "", error);
		}
		return success("LoanTrade", ValidationType.CARDINALITY, "LoanTrade", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTrade o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTrade", ValidationType.CARDINALITY, "LoanTrade", path, "", res.getError());
				}
				return success("LoanTrade", ValidationType.CARDINALITY, "LoanTrade", path, "");
			})
			.collect(toList());
	}

}
