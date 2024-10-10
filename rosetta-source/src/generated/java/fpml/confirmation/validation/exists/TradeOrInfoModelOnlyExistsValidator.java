package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeOrInfoModel;
import fpml.confirmation.TradeOrInfoModelSequence;
import fpml.confirmation.TradePackage;
import fpml.confirmation.TradeReferenceInformationModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeOrInfoModelOnlyExistsValidator implements ValidatorWithArg<TradeOrInfoModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeOrInfoModel> ValidationResult<TradeOrInfoModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tradeOrInfoModelSequence", ExistenceChecker.isSet((TradeOrInfoModelSequence) o.getTradeOrInfoModelSequence()))
				.put("tradeReferenceInformationModel", ExistenceChecker.isSet((TradeReferenceInformationModel) o.getTradeReferenceInformationModel()))
				.put("tradePackage", ExistenceChecker.isSet((TradePackage) o.getTradePackage()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeOrInfoModel", ValidationType.ONLY_EXISTS, "TradeOrInfoModel", path, "");
		}
		return failure("TradeOrInfoModel", ValidationType.ONLY_EXISTS, "TradeOrInfoModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
