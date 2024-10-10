package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
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
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanTradeOnlyExistsValidator implements ValidatorWithArg<LoanTrade, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanTrade> ValidationResult<LoanTrade> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tradeIdentifier", ExistenceChecker.isSet((TradeIdentifier) o.getTradeIdentifier()))
				.put("facilityReference", ExistenceChecker.isSet((FacilityReference) o.getFacilityReference()))
				.put("amount", ExistenceChecker.isSet((Money) o.getAmount()))
				.put("comment", ExistenceChecker.isSet((String) o.getComment()))
				.put("tradeDate", ExistenceChecker.isSet((Date) o.getTradeDate()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("type", ExistenceChecker.isSet((LoanTradingTypeEnum) o.getType()))
				.put("whenIssuedFlag", ExistenceChecker.isSet((Boolean) o.getWhenIssuedFlag()))
				.put("loanTradingSettlementTermsModel", ExistenceChecker.isSet((LoanTradingSettlementTermsModel) o.getLoanTradingSettlementTermsModel()))
				.put("price", ExistenceChecker.isSet((BigDecimal) o.getPrice()))
				.put("transferFee", ExistenceChecker.isSet((LoanTransferFee) o.getTransferFee()))
				.put("loanTradingCounterpartyCashSettlementRulesModel", ExistenceChecker.isSet((LoanTradingCounterpartyCashSettlementRulesModel) o.getLoanTradingCounterpartyCashSettlementRulesModel()))
				.put("loanTradingParticipationSettlementTermsModel", ExistenceChecker.isSet((LoanTradingParticipationSettlementTermsModel) o.getLoanTradingParticipationSettlementTermsModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanTrade", ValidationType.ONLY_EXISTS, "LoanTrade", path, "");
		}
		return failure("LoanTrade", ValidationType.ONLY_EXISTS, "LoanTrade", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
