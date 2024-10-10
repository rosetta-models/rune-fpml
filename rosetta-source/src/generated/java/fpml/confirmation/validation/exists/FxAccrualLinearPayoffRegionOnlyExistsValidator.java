package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualLeverage;
import fpml.confirmation.FxAccrualLinearPayoffRegion;
import fpml.confirmation.FxAccrualLinearPayoffRegionSequence;
import fpml.confirmation.FxAccrualRegionBoundModel;
import fpml.confirmation.FxAverageStrike;
import fpml.confirmation.FxExchangedCurrencyModel;
import fpml.confirmation.FxPayoffCap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAccrualLinearPayoffRegionOnlyExistsValidator implements ValidatorWithArg<FxAccrualLinearPayoffRegion, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAccrualLinearPayoffRegion> ValidationResult<FxAccrualLinearPayoffRegion> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("fxExchangedCurrencyModel", ExistenceChecker.isSet((FxExchangedCurrencyModel) o.getFxExchangedCurrencyModel()))
				.put("fxAccrualLinearPayoffRegionSequence", ExistenceChecker.isSet((FxAccrualLinearPayoffRegionSequence) o.getFxAccrualLinearPayoffRegionSequence()))
				.put("averageStrike", ExistenceChecker.isSet((FxAverageStrike) o.getAverageStrike()))
				.put("fxAccrualRegionBoundModel", ExistenceChecker.isSet((FxAccrualRegionBoundModel) o.getFxAccrualRegionBoundModel()))
				.put("leverage", ExistenceChecker.isSet((FxAccrualLeverage) o.getLeverage()))
				.put("payoffCap", ExistenceChecker.isSet((List<? extends FxPayoffCap>) o.getPayoffCap()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAccrualLinearPayoffRegion", ValidationType.ONLY_EXISTS, "FxAccrualLinearPayoffRegion", path, "");
		}
		return failure("FxAccrualLinearPayoffRegion", ValidationType.ONLY_EXISTS, "FxAccrualLinearPayoffRegion", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
