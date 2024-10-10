package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableDate2;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.CashflowNotional;
import fpml.confirmation.GenericCommodityAttributesModel;
import fpml.confirmation.GenericEquityAttributesModel;
import fpml.confirmation.GenericFrequency;
import fpml.confirmation.GenericOptionAttributesModel;
import fpml.confirmation.GenericProduct;
import fpml.confirmation.GenericResetFrequency;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.PartyReference;
import fpml.confirmation.Payment;
import fpml.confirmation.ProductModel;
import fpml.confirmation.SettlementTypeEnum;
import fpml.confirmation.SimplePayment;
import fpml.confirmation.TradeUnderlyer2;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GenericProductOnlyExistsValidator implements ValidatorWithArg<GenericProduct, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GenericProduct> ValidationResult<GenericProduct> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("multiLeg", ExistenceChecker.isSet((Boolean) o.getMultiLeg()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("counterpartyReference", ExistenceChecker.isSet((List<? extends PartyReference>) o.getCounterpartyReference()))
				.put("premium", ExistenceChecker.isSet((SimplePayment) o.getPremium()))
				.put("effectiveDate", ExistenceChecker.isSet((AdjustableDate2) o.getEffectiveDate()))
				.put("expirationDate", ExistenceChecker.isSet((AdjustableDate2) o.getExpirationDate()))
				.put("terminationDate", ExistenceChecker.isSet((AdjustableDate2) o.getTerminationDate()))
				.put("underlyer", ExistenceChecker.isSet((List<? extends TradeUnderlyer2>) o.getUnderlyer()))
				.put("notional", ExistenceChecker.isSet((List<? extends CashflowNotional>) o.getNotional()))
				.put("genericCommodityAttributesModel", ExistenceChecker.isSet((GenericCommodityAttributesModel) o.getGenericCommodityAttributesModel()))
				.put("genericEquityAttributesModel", ExistenceChecker.isSet((GenericEquityAttributesModel) o.getGenericEquityAttributesModel()))
				.put("genericOptionAttributesModel", ExistenceChecker.isSet((GenericOptionAttributesModel) o.getGenericOptionAttributesModel()))
				.put("paymentFrequency", ExistenceChecker.isSet((List<? extends GenericFrequency>) o.getPaymentFrequency()))
				.put("resetFrequency", ExistenceChecker.isSet((List<? extends GenericResetFrequency>) o.getResetFrequency()))
				.put("settlementCurrency", ExistenceChecker.isSet((List<? extends IdentifiedCurrency>) o.getSettlementCurrency()))
				.put("settlementType", ExistenceChecker.isSet((SettlementTypeEnum) o.getSettlementType()))
				.put("additionalPayment", ExistenceChecker.isSet((List<? extends Payment>) o.getAdditionalPayment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GenericProduct", ValidationType.ONLY_EXISTS, "GenericProduct", path, "");
		}
		return failure("GenericProduct", ValidationType.ONLY_EXISTS, "GenericProduct", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
