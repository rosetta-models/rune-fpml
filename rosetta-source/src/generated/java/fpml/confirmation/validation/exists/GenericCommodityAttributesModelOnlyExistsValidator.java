package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityQuantityFrequency;
import fpml.confirmation.FixedPrice;
import fpml.confirmation.GenericCommodityAttributesModel;
import fpml.confirmation.GenericCommodityDeliveryPeriod;
import fpml.confirmation.GenericCommodityGrade;
import fpml.confirmation.InterconnectionPoint;
import fpml.confirmation.LoadTypeEnum;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GenericCommodityAttributesModelOnlyExistsValidator implements ValidatorWithArg<GenericCommodityAttributesModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GenericCommodityAttributesModel> ValidationResult<GenericCommodityAttributesModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("grade", ExistenceChecker.isSet((List<? extends GenericCommodityGrade>) o.getGrade()))
				.put("settlementPeriods", ExistenceChecker.isSet((List<? extends GenericCommodityDeliveryPeriod>) o.getSettlementPeriods()))
				.put("loadType", ExistenceChecker.isSet((LoadTypeEnum) o.getLoadType()))
				.put("quantity", ExistenceChecker.isSet((BigDecimal) o.getQuantity()))
				.put("quantityFrequency", ExistenceChecker.isSet((CommodityQuantityFrequency) o.getQuantityFrequency()))
				.put("fixedPrice", ExistenceChecker.isSet((FixedPrice) o.getFixedPrice()))
				.put("interconnectionPoint", ExistenceChecker.isSet((InterconnectionPoint) o.getInterconnectionPoint()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GenericCommodityAttributesModel", ValidationType.ONLY_EXISTS, "GenericCommodityAttributesModel", path, "");
		}
		return failure("GenericCommodityAttributesModel", ValidationType.ONLY_EXISTS, "GenericCommodityAttributesModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
