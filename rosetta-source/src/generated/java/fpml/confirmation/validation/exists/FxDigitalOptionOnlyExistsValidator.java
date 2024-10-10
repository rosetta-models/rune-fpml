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
import fpml.confirmation.FxDigitalOption;
import fpml.confirmation.FxDigitalOptionSequence0;
import fpml.confirmation.FxDigitalOptionSequence1;
import fpml.confirmation.FxOptionPayout;
import fpml.confirmation.FxOptionPremium;
import fpml.confirmation.Period;
import fpml.confirmation.ProductModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxDigitalOptionOnlyExistsValidator implements ValidatorWithArg<FxDigitalOption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxDigitalOption> ValidationResult<FxDigitalOption> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("effectiveDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getEffectiveDate()))
				.put("tenorPeriod", ExistenceChecker.isSet((Period) o.getTenorPeriod()))
				.put("fxDigitalOptionSequence0", ExistenceChecker.isSet((FxDigitalOptionSequence0) o.getFxDigitalOptionSequence0()))
				.put("fxDigitalOptionSequence1", ExistenceChecker.isSet((FxDigitalOptionSequence1) o.getFxDigitalOptionSequence1()))
				.put("exerciseProcedure", ExistenceChecker.isSet((ExerciseProcedure) o.getExerciseProcedure()))
				.put("payout", ExistenceChecker.isSet((FxOptionPayout) o.getPayout()))
				.put("premium", ExistenceChecker.isSet((List<? extends FxOptionPremium>) o.getPremium()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxDigitalOption", ValidationType.ONLY_EXISTS, "FxDigitalOption", path, "");
		}
		return failure("FxDigitalOption", ValidationType.ONLY_EXISTS, "FxDigitalOption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
