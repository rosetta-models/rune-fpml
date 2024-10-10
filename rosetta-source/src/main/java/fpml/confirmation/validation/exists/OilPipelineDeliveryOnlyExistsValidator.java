package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityDeliveryPoint;
import fpml.confirmation.CommodityDeliveryRisk;
import fpml.confirmation.CommodityPipeline;
import fpml.confirmation.CommodityPipelineCycle;
import fpml.confirmation.OilPipelineDelivery;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OilPipelineDeliveryOnlyExistsValidator implements ValidatorWithArg<OilPipelineDelivery, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OilPipelineDelivery> ValidationResult<OilPipelineDelivery> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("pipelineName", ExistenceChecker.isSet((CommodityPipeline) o.getPipelineName()))
				.put("withdrawalPoint", ExistenceChecker.isSet((CommodityDeliveryPoint) o.getWithdrawalPoint()))
				.put("entryPoint", ExistenceChecker.isSet((CommodityDeliveryPoint) o.getEntryPoint()))
				.put("deliverableByBarge", ExistenceChecker.isSet((Boolean) o.getDeliverableByBarge()))
				.put("risk", ExistenceChecker.isSet((CommodityDeliveryRisk) o.getRisk()))
				.put("cycle", ExistenceChecker.isSet((List<? extends CommodityPipelineCycle>) o.getCycle()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OilPipelineDelivery", ValidationType.ONLY_EXISTS, "OilPipelineDelivery", path, "");
		}
		return failure("OilPipelineDelivery", ValidationType.ONLY_EXISTS, "OilPipelineDelivery", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
