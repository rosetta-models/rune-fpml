package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxBarrierDirectionEnum;
import fpml.confirmation.FxBarrierFeature;
import fpml.confirmation.FxBarrierFeatureSequence;
import fpml.confirmation.FxBarrierTypeEnum;
import fpml.confirmation.FxBusinessCenterDateTime;
import fpml.confirmation.InformationSource;
import fpml.confirmation.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxBarrierFeatureOnlyExistsValidator implements ValidatorWithArg<FxBarrierFeature, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxBarrierFeature> ValidationResult<FxBarrierFeature> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("barrierType", ExistenceChecker.isSet((FxBarrierTypeEnum) o.getBarrierType()))
				.put("direction", ExistenceChecker.isSet((FxBarrierDirectionEnum) o.getDirection()))
				.put("quotedCurrencyPair", ExistenceChecker.isSet((QuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("triggerRate", ExistenceChecker.isSet((BigDecimal) o.getTriggerRate()))
				.put("informationSource", ExistenceChecker.isSet((List<? extends InformationSource>) o.getInformationSource()))
				.put("fxBarrierFeatureSequence", ExistenceChecker.isSet((FxBarrierFeatureSequence) o.getFxBarrierFeatureSequence()))
				.put("observationPoint", ExistenceChecker.isSet((List<? extends FxBusinessCenterDateTime>) o.getObservationPoint()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxBarrierFeature", ValidationType.ONLY_EXISTS, "FxBarrierFeature", path, "");
		}
		return failure("FxBarrierFeature", ValidationType.ONLY_EXISTS, "FxBarrierFeature", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
