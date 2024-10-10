package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Asset;
import fpml.confirmation.BasketConstituent;
import fpml.confirmation.Collateral;
import fpml.confirmation.ConstituentWeight;
import fpml.confirmation.DividendPayout;
import fpml.confirmation.Money;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PendingPayment;
import fpml.confirmation.Price;
import fpml.confirmation.SpreadScheduleReference;
import fpml.confirmation.UnderlyerInterestLeg;
import fpml.confirmation.UnderlyerLoanRate;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class BasketConstituentOnlyExistsValidator implements ValidatorWithArg<BasketConstituent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends BasketConstituent> ValidationResult<BasketConstituent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("payerReceiverModel", ExistenceChecker.isSet((PayerReceiverModel) o.getPayerReceiverModel()))
				.put("underlyingAsset", ExistenceChecker.isSet((Asset) o.getUnderlyingAsset()))
				.put("constituentWeight", ExistenceChecker.isSet((ConstituentWeight) o.getConstituentWeight()))
				.put("dividendPayout", ExistenceChecker.isSet((DividendPayout) o.getDividendPayout()))
				.put("underlyerPrice", ExistenceChecker.isSet((Price) o.getUnderlyerPrice()))
				.put("underlyerNotional", ExistenceChecker.isSet((Money) o.getUnderlyerNotional()))
				.put("underlyerSpread", ExistenceChecker.isSet((SpreadScheduleReference) o.getUnderlyerSpread()))
				.put("couponPayment", ExistenceChecker.isSet((PendingPayment) o.getCouponPayment()))
				.put("underlyerFinancing", ExistenceChecker.isSet((UnderlyerInterestLeg) o.getUnderlyerFinancing()))
				.put("underlyerLoanRate", ExistenceChecker.isSet((UnderlyerLoanRate) o.getUnderlyerLoanRate()))
				.put("underlyerCollateral", ExistenceChecker.isSet((Collateral) o.getUnderlyerCollateral()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BasketConstituent", ValidationType.ONLY_EXISTS, "BasketConstituent", path, "");
		}
		return failure("BasketConstituent", ValidationType.ONLY_EXISTS, "BasketConstituent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
