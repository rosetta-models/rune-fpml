package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.AveragingPeriod;
import fpml.confirmation.FxFeature;
import fpml.confirmation.LegIdentifier;
import fpml.confirmation.NotionalAdjustmentEnum;
import fpml.confirmation.OptionSettlementModel;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.Return;
import fpml.confirmation.ReturnLeg;
import fpml.confirmation.ReturnLegValuation;
import fpml.confirmation.ReturnSwapAmount;
import fpml.confirmation.ReturnSwapNotional;
import fpml.confirmation.Underlyer;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReturnLegOnlyExistsValidator implements ValidatorWithArg<ReturnLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReturnLeg> ValidationResult<ReturnLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("legIdentifier", ExistenceChecker.isSet((List<? extends LegIdentifier>) o.getLegIdentifier()))
				.put("payerReceiverModel", ExistenceChecker.isSet((PayerReceiverModel) o.getPayerReceiverModel()))
				.put("effectiveDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getEffectiveDate()))
				.put("terminationDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getTerminationDate()))
				.put("strikeDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getStrikeDate()))
				.put("underlyer", ExistenceChecker.isSet((Underlyer) o.getUnderlyer()))
				.put("optionSettlementModel", ExistenceChecker.isSet((OptionSettlementModel) o.getOptionSettlementModel()))
				.put("rateOfReturn", ExistenceChecker.isSet((ReturnLegValuation) o.getRateOfReturn()))
				.put("notional", ExistenceChecker.isSet((ReturnSwapNotional) o.getNotional()))
				.put("amount", ExistenceChecker.isSet((ReturnSwapAmount) o.getAmount()))
				.put("return", ExistenceChecker.isSet((Return) o.getReturn()))
				.put("notionalAdjustments", ExistenceChecker.isSet((NotionalAdjustmentEnum) o.getNotionalAdjustments()))
				.put("fxFeature", ExistenceChecker.isSet((FxFeature) o.getFxFeature()))
				.put("averagingDates", ExistenceChecker.isSet((AveragingPeriod) o.getAveragingDates()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReturnLeg", ValidationType.ONLY_EXISTS, "ReturnLeg", path, "");
		}
		return failure("ReturnLeg", ValidationType.ONLY_EXISTS, "ReturnLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
