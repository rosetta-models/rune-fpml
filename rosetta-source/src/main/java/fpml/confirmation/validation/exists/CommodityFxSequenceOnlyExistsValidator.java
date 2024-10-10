package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.CommodityFxSequence;
import fpml.confirmation.CommodityFxSequenceSequence;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityFxSequenceOnlyExistsValidator implements ValidatorWithArg<CommodityFxSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityFxSequence> ValidationResult<CommodityFxSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fxObservationDates", ExistenceChecker.isSet((List<? extends AdjustableDates>) o.getFxObservationDates()))
				.put("commodityFxSequenceSequence", ExistenceChecker.isSet((CommodityFxSequenceSequence) o.getCommodityFxSequenceSequence()))
				.put("fixingTime", ExistenceChecker.isSet((BusinessCenterTime) o.getFixingTime()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityFxSequence", ValidationType.ONLY_EXISTS, "CommodityFxSequence", path, "");
		}
		return failure("CommodityFxSequence", ValidationType.ONLY_EXISTS, "CommodityFxSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
