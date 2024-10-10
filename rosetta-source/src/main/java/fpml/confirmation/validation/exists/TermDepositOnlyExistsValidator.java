package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FxTenorModel;
import fpml.confirmation.Money;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.Payment;
import fpml.confirmation.PositiveMoney;
import fpml.confirmation.ProductModel;
import fpml.confirmation.TermDeposit;
import fpml.confirmation.TermDepositFeatures;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TermDepositOnlyExistsValidator implements ValidatorWithArg<TermDeposit, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TermDeposit> ValidationResult<TermDeposit> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerReceiverModel", ExistenceChecker.isSet((PayerReceiverModel) o.getPayerReceiverModel()))
				.put("startDate", ExistenceChecker.isSet((Date) o.getStartDate()))
				.put("maturityDate", ExistenceChecker.isSet((Date) o.getMaturityDate()))
				.put("fxTenorModel", ExistenceChecker.isSet((FxTenorModel) o.getFxTenorModel()))
				.put("principal", ExistenceChecker.isSet((PositiveMoney) o.getPrincipal()))
				.put("fixedRate", ExistenceChecker.isSet((BigDecimal) o.getFixedRate()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("features", ExistenceChecker.isSet((TermDepositFeatures) o.getFeatures()))
				.put("interest", ExistenceChecker.isSet((Money) o.getInterest()))
				.put("payment", ExistenceChecker.isSet((List<? extends Payment>) o.getPayment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TermDeposit", ValidationType.ONLY_EXISTS, "TermDeposit", path, "");
		}
		return failure("TermDeposit", ValidationType.ONLY_EXISTS, "TermDeposit", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
