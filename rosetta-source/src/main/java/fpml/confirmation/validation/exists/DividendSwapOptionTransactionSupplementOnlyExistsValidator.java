package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.DividendSwapOptionTransactionSupplement;
import fpml.confirmation.DividendSwapTransactionSupplement;
import fpml.confirmation.EquityExerciseValuationSettlement;
import fpml.confirmation.EquityPremium;
import fpml.confirmation.MethodOfAdjustmentEnum;
import fpml.confirmation.OptionTypeEnum;
import fpml.confirmation.ProductModel;
import fpml.confirmation.SwaptionPhysicalSettlement;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DividendSwapOptionTransactionSupplementOnlyExistsValidator implements ValidatorWithArg<DividendSwapOptionTransactionSupplement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DividendSwapOptionTransactionSupplement> ValidationResult<DividendSwapOptionTransactionSupplement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("optionType", ExistenceChecker.isSet((OptionTypeEnum) o.getOptionType()))
				.put("equityPremium", ExistenceChecker.isSet((EquityPremium) o.getEquityPremium()))
				.put("equityExercise", ExistenceChecker.isSet((EquityExerciseValuationSettlement) o.getEquityExercise()))
				.put("exchangeLookAlike", ExistenceChecker.isSet((Boolean) o.getExchangeLookAlike()))
				.put("methodOfAdjustment", ExistenceChecker.isSet((MethodOfAdjustmentEnum) o.getMethodOfAdjustment()))
				.put("optionEntitlement", ExistenceChecker.isSet((BigDecimal) o.getOptionEntitlement()))
				.put("multiplier", ExistenceChecker.isSet((BigDecimal) o.getMultiplier()))
				.put("clearingInstructions", ExistenceChecker.isSet((SwaptionPhysicalSettlement) o.getClearingInstructions()))
				.put("dividendSwapTransactionSupplement", ExistenceChecker.isSet((DividendSwapTransactionSupplement) o.getDividendSwapTransactionSupplement()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DividendSwapOptionTransactionSupplement", ValidationType.ONLY_EXISTS, "DividendSwapOptionTransactionSupplement", path, "");
		}
		return failure("DividendSwapOptionTransactionSupplement", ValidationType.ONLY_EXISTS, "DividendSwapOptionTransactionSupplement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
