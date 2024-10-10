package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PricingCoordinateOrReferenceModel;
import fpml.confirmation.PricingStructurePoint;
import fpml.confirmation.QuotationModel;
import fpml.confirmation.UnderlyingAssetOrReferenceModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PricingStructurePointOnlyExistsValidator implements ValidatorWithArg<PricingStructurePoint, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PricingStructurePoint> ValidationResult<PricingStructurePoint> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("pricingCoordinateOrReferenceModel", ExistenceChecker.isSet((List<? extends PricingCoordinateOrReferenceModel>) o.getPricingCoordinateOrReferenceModel()))
				.put("underlyingAssetOrReferenceModel", ExistenceChecker.isSet((UnderlyingAssetOrReferenceModel) o.getUnderlyingAssetOrReferenceModel()))
				.put("quotationModel", ExistenceChecker.isSet((QuotationModel) o.getQuotationModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PricingStructurePoint", ValidationType.ONLY_EXISTS, "PricingStructurePoint", path, "");
		}
		return failure("PricingStructurePoint", ValidationType.ONLY_EXISTS, "PricingStructurePoint", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
