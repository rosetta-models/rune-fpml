package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OtcClassification;
import fpml.confirmation.ShortSale;
import fpml.confirmation.TradingWaiver;
import fpml.confirmation.TransactionClassificationModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TransactionClassificationModelOnlyExistsValidator implements ValidatorWithArg<TransactionClassificationModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TransactionClassificationModel> ValidationResult<TransactionClassificationModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("isSecuritiesFinancing", ExistenceChecker.isSet((Boolean) o.getIsSecuritiesFinancing()))
				.put("otcClassification", ExistenceChecker.isSet((List<? extends OtcClassification>) o.getOtcClassification()))
				.put("tradingWaiver", ExistenceChecker.isSet((List<? extends TradingWaiver>) o.getTradingWaiver()))
				.put("shortSale", ExistenceChecker.isSet((ShortSale) o.getShortSale()))
				.put("isCommodityHedge", ExistenceChecker.isSet((Boolean) o.getIsCommodityHedge()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TransactionClassificationModel", ValidationType.ONLY_EXISTS, "TransactionClassificationModel", path, "");
		}
		return failure("TransactionClassificationModel", ValidationType.ONLY_EXISTS, "TransactionClassificationModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
