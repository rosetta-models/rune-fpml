package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.Exercise;
import fpml.confirmation.ExerciseProcedure;
import fpml.confirmation.Money;
import fpml.confirmation.NotionalAmountReference;
import fpml.confirmation.OptionBaseExtended;
import fpml.confirmation.OptionDenominationModel;
import fpml.confirmation.OptionFeature;
import fpml.confirmation.OptionSettlementModel;
import fpml.confirmation.OptionTypeEnum;
import fpml.confirmation.Premium;
import fpml.confirmation.ProductModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionBaseExtendedOnlyExistsValidator implements ValidatorWithArg<OptionBaseExtended, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionBaseExtended> ValidationResult<OptionBaseExtended> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionBaseExtended", ValidationType.ONLY_EXISTS, "OptionBaseExtended", path, "");
		}
		return failure("OptionBaseExtended", ValidationType.ONLY_EXISTS, "OptionBaseExtended", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
