package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.CreditDefaultSwap;
import fpml.confirmation.CreditDefaultSwapOption;
import fpml.confirmation.CreditOptionStrike;
import fpml.confirmation.Exercise;
import fpml.confirmation.ExerciseProcedure;
import fpml.confirmation.Money;
import fpml.confirmation.NotionalAmountReference;
import fpml.confirmation.OptionDenominationModel;
import fpml.confirmation.OptionFeature;
import fpml.confirmation.OptionSettlementModel;
import fpml.confirmation.OptionTypeEnum;
import fpml.confirmation.Premium;
import fpml.confirmation.ProductModel;
import fpml.confirmation.SwaptionPhysicalSettlement;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditDefaultSwapOptionOnlyExistsValidator implements ValidatorWithArg<CreditDefaultSwapOption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditDefaultSwapOption> ValidationResult<CreditDefaultSwapOption> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("optionType", ExistenceChecker.isSet((OptionTypeEnum) o.getOptionType()))
				.put("premium", ExistenceChecker.isSet((Premium) o.getPremium()))
				.put("exercise", ExistenceChecker.isSet((Exercise) o.getExercise()))
				.put("exerciseProcedure", ExistenceChecker.isSet((ExerciseProcedure) o.getExerciseProcedure()))
				.put("feature", ExistenceChecker.isSet((OptionFeature) o.getFeature()))
				.put("notionalReference", ExistenceChecker.isSet((NotionalAmountReference) o.getNotionalReference()))
				.put("notionalAmount", ExistenceChecker.isSet((Money) o.getNotionalAmount()))
				.put("optionDenominationModel", ExistenceChecker.isSet((OptionDenominationModel) o.getOptionDenominationModel()))
				.put("optionSettlementModel", ExistenceChecker.isSet((OptionSettlementModel) o.getOptionSettlementModel()))
				.put("clearingInstructions", ExistenceChecker.isSet((SwaptionPhysicalSettlement) o.getClearingInstructions()))
				.put("strike", ExistenceChecker.isSet((CreditOptionStrike) o.getStrike()))
				.put("creditDefaultSwap", ExistenceChecker.isSet((CreditDefaultSwap) o.getCreditDefaultSwap()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditDefaultSwapOption", ValidationType.ONLY_EXISTS, "CreditDefaultSwapOption", path, "");
		}
		return failure("CreditDefaultSwapOption", ValidationType.ONLY_EXISTS, "CreditDefaultSwapOption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
