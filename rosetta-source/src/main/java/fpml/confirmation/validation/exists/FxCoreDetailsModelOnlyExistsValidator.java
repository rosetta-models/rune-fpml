package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DealtCurrencyEnum;
import fpml.confirmation.ExchangeRate;
import fpml.confirmation.FxCashSettlement;
import fpml.confirmation.FxCoreDetailsModel;
import fpml.confirmation.FxCoreDetailsModelSequence;
import fpml.confirmation.FxDisruption;
import fpml.confirmation.FxTenorModel;
import fpml.confirmation.Payment;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxCoreDetailsModelOnlyExistsValidator implements ValidatorWithArg<FxCoreDetailsModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxCoreDetailsModel> ValidationResult<FxCoreDetailsModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("exchangedCurrency1", ExistenceChecker.isSet((Payment) o.getExchangedCurrency1()))
				.put("exchangedCurrency2", ExistenceChecker.isSet((Payment) o.getExchangedCurrency2()))
				.put("dealtCurrency", ExistenceChecker.isSet((DealtCurrencyEnum) o.getDealtCurrency()))
				.put("fxTenorModel", ExistenceChecker.isSet((FxTenorModel) o.getFxTenorModel()))
				.put("valueDate", ExistenceChecker.isSet((Date) o.getValueDate()))
				.put("fxCoreDetailsModelSequence", ExistenceChecker.isSet((FxCoreDetailsModelSequence) o.getFxCoreDetailsModelSequence()))
				.put("exchangeRate", ExistenceChecker.isSet((ExchangeRate) o.getExchangeRate()))
				.put("nonDeliverableSettlement", ExistenceChecker.isSet((FxCashSettlement) o.getNonDeliverableSettlement()))
				.put("disruption", ExistenceChecker.isSet((List<? extends FxDisruption>) o.getDisruption()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxCoreDetailsModel", ValidationType.ONLY_EXISTS, "FxCoreDetailsModel", path, "");
		}
		return failure("FxCoreDetailsModel", ValidationType.ONLY_EXISTS, "FxCoreDetailsModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
