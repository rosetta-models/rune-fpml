package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityBase;
import fpml.confirmation.CommodityDetails;
import fpml.confirmation.CommodityInformationSource;
import fpml.confirmation.CommodityReferencePriceFrameworkModel;
import fpml.confirmation.Currency;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.QuantityUnit;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityReferencePriceFrameworkModelOnlyExistsValidator implements ValidatorWithArg<CommodityReferencePriceFrameworkModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityReferencePriceFrameworkModel> ValidationResult<CommodityReferencePriceFrameworkModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("commodityBase", ExistenceChecker.isSet((CommodityBase) o.getCommodityBase()))
				.put("commodityDetails", ExistenceChecker.isSet((CommodityDetails) o.getCommodityDetails()))
				.put("unit", ExistenceChecker.isSet((QuantityUnit) o.getUnit()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("exchangeId", ExistenceChecker.isSet((ExchangeId) o.getExchangeId()))
				.put("publication", ExistenceChecker.isSet((CommodityInformationSource) o.getPublication()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityReferencePriceFrameworkModel", ValidationType.ONLY_EXISTS, "CommodityReferencePriceFrameworkModel", path, "");
		}
		return failure("CommodityReferencePriceFrameworkModel", ValidationType.ONLY_EXISTS, "CommodityReferencePriceFrameworkModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
