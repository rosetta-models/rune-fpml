package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityHub;
import fpml.confirmation.GasDeliverySequence;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GasDeliverySequenceOnlyExistsValidator implements ValidatorWithArg<GasDeliverySequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GasDeliverySequence> ValidationResult<GasDeliverySequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("buyerHub", ExistenceChecker.isSet((CommodityHub) o.getBuyerHub()))
				.put("sellerHub", ExistenceChecker.isSet((CommodityHub) o.getSellerHub()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GasDeliverySequence", ValidationType.ONLY_EXISTS, "GasDeliverySequence", path, "");
		}
		return failure("GasDeliverySequence", ValidationType.ONLY_EXISTS, "GasDeliverySequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
