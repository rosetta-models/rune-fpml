package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AveragingMethodEnum;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.CommodityFx;
import fpml.confirmation.CommodityFxSequence;
import fpml.confirmation.CommodityFxType;
import fpml.confirmation.InformationSource;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityFxOnlyExistsValidator implements ValidatorWithArg<CommodityFx, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityFx> ValidationResult<CommodityFx> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("primaryRateSource", ExistenceChecker.isSet((InformationSource) o.getPrimaryRateSource()))
				.put("secondaryRateSource", ExistenceChecker.isSet((InformationSource) o.getSecondaryRateSource()))
				.put("fxType", ExistenceChecker.isSet((CommodityFxType) o.getFxType()))
				.put("averagingMethod", ExistenceChecker.isSet((AveragingMethodEnum) o.getAveragingMethod()))
				.put("fixingTime", ExistenceChecker.isSet((BusinessCenterTime) o.getFixingTime()))
				.put("commodityFxSequence", ExistenceChecker.isSet((CommodityFxSequence) o.getCommodityFxSequence()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityFx", ValidationType.ONLY_EXISTS, "CommodityFx", path, "");
		}
		return failure("CommodityFx", ValidationType.ONLY_EXISTS, "CommodityFx", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
