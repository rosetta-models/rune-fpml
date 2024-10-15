package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.ExerciseProcedure;
import fpml.confirmation.FxAmericanExercise;
import fpml.confirmation.FxCashSettlement;
import fpml.confirmation.FxEuropeanExercise;
import fpml.confirmation.FxOption;
import fpml.confirmation.FxOptionFeatures;
import fpml.confirmation.FxOptionPremium;
import fpml.confirmation.FxStrikePrice;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.Period;
import fpml.confirmation.ProductModel;
import fpml.confirmation.PutCallEnum;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxOptionOnlyExistsValidator implements ValidatorWithArg<FxOption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxOption> ValidationResult<FxOption> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("effectiveDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getEffectiveDate()))
				.put("tenorPeriod", ExistenceChecker.isSet((Period) o.getTenorPeriod()))
				.put("americanExercise", ExistenceChecker.isSet((FxAmericanExercise) o.getAmericanExercise()))
				.put("europeanExercise", ExistenceChecker.isSet((FxEuropeanExercise) o.getEuropeanExercise()))
				.put("exerciseProcedure", ExistenceChecker.isSet((ExerciseProcedure) o.getExerciseProcedure()))
				.put("putCurrencyAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getPutCurrencyAmount()))
				.put("callCurrencyAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getCallCurrencyAmount()))
				.put("soldAs", ExistenceChecker.isSet((PutCallEnum) o.getSoldAs()))
				.put("strike", ExistenceChecker.isSet((FxStrikePrice) o.getStrike()))
				.put("spotRate", ExistenceChecker.isSet((BigDecimal) o.getSpotRate()))
				.put("features", ExistenceChecker.isSet((FxOptionFeatures) o.getFeatures()))
				.put("premium", ExistenceChecker.isSet((FxOptionPremium) o.getPremium()))
				.put("cashSettlement", ExistenceChecker.isSet((FxCashSettlement) o.getCashSettlement()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxOption", ValidationType.ONLY_EXISTS, "FxOption", path, "");
		}
		return failure("FxOption", ValidationType.ONLY_EXISTS, "FxOption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
