package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.CalculationAgent;
import fpml.confirmation.CashSettlement;
import fpml.confirmation.Exercise;
import fpml.confirmation.ExerciseProcedure;
import fpml.confirmation.Payment;
import fpml.confirmation.ProductModel;
import fpml.confirmation.Swap;
import fpml.confirmation.Swaption;
import fpml.confirmation.SwaptionAdjustedDates;
import fpml.confirmation.SwaptionPhysicalSettlement;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SwaptionOnlyExistsValidator implements ValidatorWithArg<Swaption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Swaption> ValidationResult<Swaption> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("premium", ExistenceChecker.isSet((List<? extends Payment>) o.getPremium()))
				.put("exercise", ExistenceChecker.isSet((Exercise) o.getExercise()))
				.put("exerciseProcedure", ExistenceChecker.isSet((ExerciseProcedure) o.getExerciseProcedure()))
				.put("calculationAgent", ExistenceChecker.isSet((CalculationAgent) o.getCalculationAgent()))
				.put("cashSettlement", ExistenceChecker.isSet((CashSettlement) o.getCashSettlement()))
				.put("physicalSettlement", ExistenceChecker.isSet((SwaptionPhysicalSettlement) o.getPhysicalSettlement()))
				.put("swaptionStraddle", ExistenceChecker.isSet((Boolean) o.getSwaptionStraddle()))
				.put("swaptionAdjustedDates", ExistenceChecker.isSet((SwaptionAdjustedDates) o.getSwaptionAdjustedDates()))
				.put("swap", ExistenceChecker.isSet((Swap) o.getSwap()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Swaption", ValidationType.ONLY_EXISTS, "Swaption", path, "");
		}
		return failure("Swaption", ValidationType.ONLY_EXISTS, "Swaption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
