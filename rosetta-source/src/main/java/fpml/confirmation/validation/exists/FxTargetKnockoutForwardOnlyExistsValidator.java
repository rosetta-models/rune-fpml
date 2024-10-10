package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxCashSettlementSimple;
import fpml.confirmation.FxExpirySchedule;
import fpml.confirmation.FxInformationSource;
import fpml.confirmation.FxSettlementSchedule;
import fpml.confirmation.FxTarget;
import fpml.confirmation.FxTargetBarrier;
import fpml.confirmation.FxTargetConstantPayoffRegion;
import fpml.confirmation.FxTargetKnockoutForward;
import fpml.confirmation.FxTargetKnockoutForwardChoice;
import fpml.confirmation.FxTargetKnockoutForwardSequence;
import fpml.confirmation.FxTargetLinearPayoffRegion;
import fpml.confirmation.FxTargetSettlementPeriodSchedule;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.ProductModel;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.SimplePayment;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxTargetKnockoutForwardOnlyExistsValidator implements ValidatorWithArg<FxTargetKnockoutForward, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxTargetKnockoutForward> ValidationResult<FxTargetKnockoutForward> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("quotedCurrencyPair", ExistenceChecker.isSet((QuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("notionalAmount", ExistenceChecker.isSet((NonNegativeAmountSchedule) o.getNotionalAmount()))
				.put("target", ExistenceChecker.isSet((List<? extends FxTarget>) o.getTarget()))
				.put("expirySchedule", ExistenceChecker.isSet((FxExpirySchedule) o.getExpirySchedule()))
				.put("settlementSchedule", ExistenceChecker.isSet((FxSettlementSchedule) o.getSettlementSchedule()))
				.put("fixingInformationSource", ExistenceChecker.isSet((FxInformationSource) o.getFixingInformationSource()))
				.put("spotRate", ExistenceChecker.isSet((BigDecimal) o.getSpotRate()))
				.put("fxTargetKnockoutForwardSequence", ExistenceChecker.isSet((FxTargetKnockoutForwardSequence) o.getFxTargetKnockoutForwardSequence()))
				.put("constantPayoffRegion", ExistenceChecker.isSet((List<? extends FxTargetConstantPayoffRegion>) o.getConstantPayoffRegion()))
				.put("linearPayoffRegion", ExistenceChecker.isSet((FxTargetLinearPayoffRegion) o.getLinearPayoffRegion()))
				.put("fxTargetKnockoutForwardChoice", ExistenceChecker.isSet((List<? extends FxTargetKnockoutForwardChoice>) o.getFxTargetKnockoutForwardChoice()))
				.put("barrier", ExistenceChecker.isSet((List<? extends FxTargetBarrier>) o.getBarrier()))
				.put("additionalPayment", ExistenceChecker.isSet((List<? extends SimplePayment>) o.getAdditionalPayment()))
				.put("cashSettlement", ExistenceChecker.isSet((FxCashSettlementSimple) o.getCashSettlement()))
				.put("settlementPeriodSchedule", ExistenceChecker.isSet((FxTargetSettlementPeriodSchedule) o.getSettlementPeriodSchedule()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxTargetKnockoutForward", ValidationType.ONLY_EXISTS, "FxTargetKnockoutForward", path, "");
		}
		return failure("FxTargetKnockoutForward", ValidationType.ONLY_EXISTS, "FxTargetKnockoutForward", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
