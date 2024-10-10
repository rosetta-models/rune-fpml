package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.FxFlexibleForward;
import fpml.confirmation.FxFlexibleForwardExecutionPeriod;
import fpml.confirmation.FxFlexibleForwardRate;
import fpml.confirmation.FxFlexibleForwardSequence;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.Payment;
import fpml.confirmation.PositiveMoney;
import fpml.confirmation.ProductModel;
import fpml.confirmation.PutCallCurrencyModel;
import fpml.confirmation.RelativeDateOffset;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxFlexibleForwardOnlyExistsValidator implements ValidatorWithArg<FxFlexibleForward, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxFlexibleForward> ValidationResult<FxFlexibleForward> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("putCallCurrencyModel", ExistenceChecker.isSet((PutCallCurrencyModel) o.getPutCallCurrencyModel()))
				.put("notionalAmount", ExistenceChecker.isSet((PositiveMoney) o.getNotionalAmount()))
				.put("minimumExecutionAmount", ExistenceChecker.isSet((PositiveMoney) o.getMinimumExecutionAmount()))
				.put("settlementAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getSettlementAmount()))
				.put("executionPeriodDates", ExistenceChecker.isSet((FxFlexibleForwardExecutionPeriod) o.getExecutionPeriodDates()))
				.put("fxFlexibleForwardSequence", ExistenceChecker.isSet((FxFlexibleForwardSequence) o.getFxFlexibleForwardSequence()))
				.put("settlementDateOffset", ExistenceChecker.isSet((RelativeDateOffset) o.getSettlementDateOffset()))
				.put("finalSettlementDate", ExistenceChecker.isSet((Date) o.getFinalSettlementDate()))
				.put("forwardRate", ExistenceChecker.isSet((FxFlexibleForwardRate) o.getForwardRate()))
				.put("additionalPayment", ExistenceChecker.isSet((Payment) o.getAdditionalPayment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxFlexibleForward", ValidationType.ONLY_EXISTS, "FxFlexibleForward", path, "");
		}
		return failure("FxFlexibleForward", ValidationType.ONLY_EXISTS, "FxFlexibleForward", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
