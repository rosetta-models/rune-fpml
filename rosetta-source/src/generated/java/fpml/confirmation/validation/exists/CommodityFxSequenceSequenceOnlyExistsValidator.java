package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommodityFxSequenceSequence;
import fpml.confirmation.CommodityFxSequenceSequenceSequence;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityFxSequenceSequenceOnlyExistsValidator implements ValidatorWithArg<CommodityFxSequenceSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityFxSequenceSequence> ValidationResult<CommodityFxSequenceSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("commodityFxSequenceSequenceSequence", ExistenceChecker.isSet((CommodityFxSequenceSequenceSequence) o.getCommodityFxSequenceSequenceSequence()))
				.put("commodityCalculationPeriodsPointerModel", ExistenceChecker.isSet((CommodityCalculationPeriodsPointerModel) o.getCommodityCalculationPeriodsPointerModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityFxSequenceSequence", ValidationType.ONLY_EXISTS, "CommodityFxSequenceSequence", path, "");
		}
		return failure("CommodityFxSequenceSequence", ValidationType.ONLY_EXISTS, "CommodityFxSequenceSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
