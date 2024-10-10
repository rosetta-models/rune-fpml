package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BuySellEnum;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LoanTradingSettlementTermsModel;
import fpml.confirmation.LoanTradingTypeEnum;
import fpml.confirmation.LoanTransfer;
import fpml.confirmation.Money;
import fpml.confirmation.TradeIdentifier;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanTransferOnlyExistsValidator implements ValidatorWithArg<LoanTransfer, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanTransfer> ValidationResult<LoanTransfer> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tradeIdentifier", ExistenceChecker.isSet((TradeIdentifier) o.getTradeIdentifier()))
				.put("facilityReference", ExistenceChecker.isSet((FacilityReference) o.getFacilityReference()))
				.put("amount", ExistenceChecker.isSet((Money) o.getAmount()))
				.put("comment", ExistenceChecker.isSet((String) o.getComment()))
				.put("tradeDate", ExistenceChecker.isSet((Date) o.getTradeDate()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("type", ExistenceChecker.isSet((LoanTradingTypeEnum) o.getType_()))
				.put("whenIssuedFlag", ExistenceChecker.isSet((Boolean) o.getWhenIssuedFlag()))
				.put("loanTradingSettlementTermsModel", ExistenceChecker.isSet((LoanTradingSettlementTermsModel) o.getLoanTradingSettlementTermsModel()))
				.put("transferFeeRemittedBy", ExistenceChecker.isSet((BuySellEnum) o.getTransferFeeRemittedBy()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanTransfer", ValidationType.ONLY_EXISTS, "LoanTransfer", path, "");
		}
		return failure("LoanTransfer", ValidationType.ONLY_EXISTS, "LoanTransfer", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
