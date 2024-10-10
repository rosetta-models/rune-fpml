package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAverageStrike;
import fpml.confirmation.FxAveragingMethodEnum;
import fpml.confirmation.FxCrossRateObservable;
import fpml.confirmation.FxInformationSource;
import fpml.confirmation.FxWeightedFixingSchedule;
import fpml.confirmation.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAverageStrikeOnlyExistsValidator implements ValidatorWithArg<FxAverageStrike, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAverageStrike> ValidationResult<FxAverageStrike> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("quotedCurrencyPair", ExistenceChecker.isSet((QuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("informationSource", ExistenceChecker.isSet((FxInformationSource) o.getInformationSource()))
				.put("crossRate", ExistenceChecker.isSet((List<? extends FxCrossRateObservable>) o.getCrossRate()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("fixingSchedule", ExistenceChecker.isSet((FxWeightedFixingSchedule) o.getFixingSchedule()))
				.put("averagingMethod", ExistenceChecker.isSet((FxAveragingMethodEnum) o.getAveragingMethod()))
				.put("precision", ExistenceChecker.isSet((Integer) o.getPrecision()))
				.put("strikeAdjustment", ExistenceChecker.isSet((BigDecimal) o.getStrikeAdjustment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAverageStrike", ValidationType.ONLY_EXISTS, "FxAverageStrike", path, "");
		}
		return failure("FxAverageStrike", ValidationType.ONLY_EXISTS, "FxAverageStrike", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
