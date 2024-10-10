package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbstractLoanTrade;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LoanTradingSettlementTermsModel;
import fpml.confirmation.LoanTradingTypeEnum;
import fpml.confirmation.Money;
import fpml.confirmation.TradeIdentifier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AbstractLoanTradeValidator implements Validator<AbstractLoanTrade> {

	private List<ComparisonResult> getComparisonResults(AbstractLoanTrade o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeIdentifier", (TradeIdentifier) o.getTradeIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("facilityReference", (FacilityReference) o.getFacilityReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("amount", (Money) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("comment", (String) o.getComment() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeDate", (Date) o.getTradeDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("type", (LoanTradingTypeEnum) o.getType_() != null ? 1 : 0, 1, 1), 
				checkCardinality("whenIssuedFlag", (Boolean) o.getWhenIssuedFlag() != null ? 1 : 0, 1, 1), 
				checkCardinality("loanTradingSettlementTermsModel", (LoanTradingSettlementTermsModel) o.getLoanTradingSettlementTermsModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<AbstractLoanTrade> validate(RosettaPath path, AbstractLoanTrade o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AbstractLoanTrade", ValidationType.CARDINALITY, "AbstractLoanTrade", path, "", error);
		}
		return success("AbstractLoanTrade", ValidationType.CARDINALITY, "AbstractLoanTrade", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractLoanTrade o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractLoanTrade", ValidationType.CARDINALITY, "AbstractLoanTrade", path, "", res.getError());
				}
				return success("AbstractLoanTrade", ValidationType.CARDINALITY, "AbstractLoanTrade", path, "");
			})
			.collect(toList());
	}

}
