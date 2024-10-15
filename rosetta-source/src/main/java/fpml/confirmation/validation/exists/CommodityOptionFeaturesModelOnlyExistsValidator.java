package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CommodityBarrier;
import fpml.confirmation.CommodityOptionFeaturesModel;
import fpml.confirmation.CommodityOptionFeaturesModelSequence;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityOptionFeaturesModelOnlyExistsValidator implements ValidatorWithArg<CommodityOptionFeaturesModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityOptionFeaturesModel> ValidationResult<CommodityOptionFeaturesModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("effectiveDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getEffectiveDate()))
				.put("terminationDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getTerminationDate()))
				.put("commodityOptionFeaturesModelSequence", ExistenceChecker.isSet((CommodityOptionFeaturesModelSequence) o.getCommodityOptionFeaturesModelSequence()))
				.put("barrier", ExistenceChecker.isSet((CommodityBarrier) o.getBarrier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityOptionFeaturesModel", ValidationType.ONLY_EXISTS, "CommodityOptionFeaturesModel", path, "");
		}
		return failure("CommodityOptionFeaturesModel", ValidationType.ONLY_EXISTS, "CommodityOptionFeaturesModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
