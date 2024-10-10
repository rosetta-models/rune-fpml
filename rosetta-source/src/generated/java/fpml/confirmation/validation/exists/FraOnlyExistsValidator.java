package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FloatingRateIndex;
import fpml.confirmation.Fra;
import fpml.confirmation.FraDiscountingEnum;
import fpml.confirmation.IdentifiedRate;
import fpml.confirmation.Money;
import fpml.confirmation.Payment;
import fpml.confirmation.Period;
import fpml.confirmation.ProductModel;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.RequiredIdentifierDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FraOnlyExistsValidator implements ValidatorWithArg<Fra, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Fra> ValidationResult<Fra> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("adjustedEffectiveDate", ExistenceChecker.isSet((RequiredIdentifierDate) o.getAdjustedEffectiveDate()))
				.put("adjustedTerminationDate", ExistenceChecker.isSet((Date) o.getAdjustedTerminationDate()))
				.put("paymentDate", ExistenceChecker.isSet((AdjustableDate) o.getPaymentDate()))
				.put("fixingDateOffset", ExistenceChecker.isSet((RelativeDateOffset) o.getFixingDateOffset()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("calculationPeriodNumberOfDays", ExistenceChecker.isSet((Integer) o.getCalculationPeriodNumberOfDays()))
				.put("notional", ExistenceChecker.isSet((Money) o.getNotional()))
				.put("fixedRate", ExistenceChecker.isSet((IdentifiedRate) o.getFixedRate()))
				.put("floatingRateIndex", ExistenceChecker.isSet((FloatingRateIndex) o.getFloatingRateIndex()))
				.put("indexTenor", ExistenceChecker.isSet((List<? extends Period>) o.getIndexTenor()))
				.put("fraDiscounting", ExistenceChecker.isSet((FraDiscountingEnum) o.getFraDiscounting()))
				.put("additionalPayment", ExistenceChecker.isSet((List<? extends Payment>) o.getAdditionalPayment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Fra", ValidationType.ONLY_EXISTS, "Fra", path, "");
		}
		return failure("Fra", ValidationType.ONLY_EXISTS, "Fra", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
