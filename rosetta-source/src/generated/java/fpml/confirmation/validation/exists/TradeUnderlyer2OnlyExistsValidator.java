package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Asset;
import fpml.confirmation.AveragingMethodEnum;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FloatingRate;
import fpml.confirmation.GenericProductExchangeRate;
import fpml.confirmation.IndexReferenceInformation;
import fpml.confirmation.LegalEntity;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.Schedule;
import fpml.confirmation.TradeUnderlyer2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeUnderlyer2OnlyExistsValidator implements ValidatorWithArg<TradeUnderlyer2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeUnderlyer2> ValidationResult<TradeUnderlyer2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("floatingRate", ExistenceChecker.isSet((FloatingRate) o.getFloatingRate()))
				.put("fixedRate", ExistenceChecker.isSet((Schedule) o.getFixedRate()))
				.put("exchangeRate", ExistenceChecker.isSet((GenericProductExchangeRate) o.getExchangeRate()))
				.put("underlyingAsset", ExistenceChecker.isSet((Asset) o.getUnderlyingAsset()))
				.put("quotedCurrencyPair", ExistenceChecker.isSet((QuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("referenceEntity", ExistenceChecker.isSet((LegalEntity) o.getReferenceEntity()))
				.put("indexReferenceInformation", ExistenceChecker.isSet((IndexReferenceInformation) o.getIndexReferenceInformation()))
				.put("averagingMethod", ExistenceChecker.isSet((AveragingMethodEnum) o.getAveragingMethod()))
				.put("payerReceiverModel", ExistenceChecker.isSet((PayerReceiverModel) o.getPayerReceiverModel()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeUnderlyer2", ValidationType.ONLY_EXISTS, "TradeUnderlyer2", path, "");
		}
		return failure("TradeUnderlyer2", ValidationType.ONLY_EXISTS, "TradeUnderlyer2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
