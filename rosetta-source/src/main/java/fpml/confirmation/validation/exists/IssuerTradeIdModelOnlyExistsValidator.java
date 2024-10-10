package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IssuerId;
import fpml.confirmation.IssuerTradeIdModel;
import fpml.confirmation.TradeId;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class IssuerTradeIdModelOnlyExistsValidator implements ValidatorWithArg<IssuerTradeIdModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends IssuerTradeIdModel> ValidationResult<IssuerTradeIdModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("issuer", ExistenceChecker.isSet((IssuerId) o.getIssuer()))
				.put("tradeId", ExistenceChecker.isSet((TradeId) o.getTradeId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("IssuerTradeIdModel", ValidationType.ONLY_EXISTS, "IssuerTradeIdModel", path, "");
		}
		return failure("IssuerTradeIdModel", ValidationType.ONLY_EXISTS, "IssuerTradeIdModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
