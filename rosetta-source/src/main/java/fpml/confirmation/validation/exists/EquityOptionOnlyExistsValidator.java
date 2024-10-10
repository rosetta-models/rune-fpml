package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.DividendConditions;
import fpml.confirmation.EquityExerciseValuationSettlement;
import fpml.confirmation.EquityOption;
import fpml.confirmation.EquityOptionTypeEnum;
import fpml.confirmation.EquityPremium;
import fpml.confirmation.EquityStrike;
import fpml.confirmation.ExtraordinaryEvents;
import fpml.confirmation.FeatureModel;
import fpml.confirmation.MethodOfAdjustmentEnum;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.ProductModel;
import fpml.confirmation.StrategyFeature;
import fpml.confirmation.Underlyer;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EquityOptionOnlyExistsValidator implements ValidatorWithArg<EquityOption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EquityOption> ValidationResult<EquityOption> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("optionType", ExistenceChecker.isSet((EquityOptionTypeEnum) o.getOptionType()))
				.put("equityEffectiveDate", ExistenceChecker.isSet((Date) o.getEquityEffectiveDate()))
				.put("underlyer", ExistenceChecker.isSet((Underlyer) o.getUnderlyer()))
				.put("notional", ExistenceChecker.isSet((NonNegativeMoney) o.getNotional()))
				.put("equityExercise", ExistenceChecker.isSet((EquityExerciseValuationSettlement) o.getEquityExercise()))
				.put("featureModel", ExistenceChecker.isSet((FeatureModel) o.getFeatureModel()))
				.put("strategyFeature", ExistenceChecker.isSet((StrategyFeature) o.getStrategyFeature()))
				.put("dividendConditions", ExistenceChecker.isSet((DividendConditions) o.getDividendConditions()))
				.put("methodOfAdjustment", ExistenceChecker.isSet((MethodOfAdjustmentEnum) o.getMethodOfAdjustment()))
				.put("extraordinaryEvents", ExistenceChecker.isSet((ExtraordinaryEvents) o.getExtraordinaryEvents()))
				.put("strike", ExistenceChecker.isSet((EquityStrike) o.getStrike()))
				.put("spotPrice", ExistenceChecker.isSet((BigDecimal) o.getSpotPrice()))
				.put("numberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getNumberOfOptions()))
				.put("optionEntitlement", ExistenceChecker.isSet((BigDecimal) o.getOptionEntitlement()))
				.put("equityPremium", ExistenceChecker.isSet((EquityPremium) o.getEquityPremium()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EquityOption", ValidationType.ONLY_EXISTS, "EquityOption", path, "");
		}
		return failure("EquityOption", ValidationType.ONLY_EXISTS, "EquityOption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
