package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CorrelationAmount;
import fpml.confirmation.CorrelationLeg;
import fpml.confirmation.EquityValuation;
import fpml.confirmation.FxFeature;
import fpml.confirmation.LegIdentifier;
import fpml.confirmation.OptionSettlementModel;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.Underlyer;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CorrelationLegOnlyExistsValidator implements ValidatorWithArg<CorrelationLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CorrelationLeg> ValidationResult<CorrelationLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("legIdentifier", ExistenceChecker.isSet((List<? extends LegIdentifier>) o.getLegIdentifier()))
				.put("payerReceiverModel", ExistenceChecker.isSet((PayerReceiverModel) o.getPayerReceiverModel()))
				.put("effectiveDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getEffectiveDate()))
				.put("terminationDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getTerminationDate()))
				.put("underlyer", ExistenceChecker.isSet((Underlyer) o.getUnderlyer()))
				.put("optionSettlementModel", ExistenceChecker.isSet((OptionSettlementModel) o.getOptionSettlementModel()))
				.put("fxFeature", ExistenceChecker.isSet((FxFeature) o.getFxFeature()))
				.put("valuation", ExistenceChecker.isSet((EquityValuation) o.getValuation()))
				.put("amount", ExistenceChecker.isSet((CorrelationAmount) o.getAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CorrelationLeg", ValidationType.ONLY_EXISTS, "CorrelationLeg", path, "");
		}
		return failure("CorrelationLeg", ValidationType.ONLY_EXISTS, "CorrelationLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
