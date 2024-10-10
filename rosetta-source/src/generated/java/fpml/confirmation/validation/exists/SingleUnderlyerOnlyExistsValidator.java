package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Asset;
import fpml.confirmation.AverageDailyTradingVolumeLimit;
import fpml.confirmation.DividendPayout;
import fpml.confirmation.PendingPayment;
import fpml.confirmation.SingleUnderlyer;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SingleUnderlyerOnlyExistsValidator implements ValidatorWithArg<SingleUnderlyer, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SingleUnderlyer> ValidationResult<SingleUnderlyer> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("underlyingAsset", ExistenceChecker.isSet((Asset) o.getUnderlyingAsset()))
				.put("openUnits", ExistenceChecker.isSet((BigDecimal) o.getOpenUnits()))
				.put("dividendPayout", ExistenceChecker.isSet((DividendPayout) o.getDividendPayout()))
				.put("couponPayment", ExistenceChecker.isSet((PendingPayment) o.getCouponPayment()))
				.put("averageDailyTradingVolume", ExistenceChecker.isSet((AverageDailyTradingVolumeLimit) o.getAverageDailyTradingVolume()))
				.put("depositoryReceipt", ExistenceChecker.isSet((Boolean) o.getDepositoryReceipt()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SingleUnderlyer", ValidationType.ONLY_EXISTS, "SingleUnderlyer", path, "");
		}
		return failure("SingleUnderlyer", ValidationType.ONLY_EXISTS, "SingleUnderlyer", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
