package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CouponType;
import fpml.confirmation.CreditSeniority;
import fpml.confirmation.FixedIncomeSecurityContentModel;
import fpml.confirmation.PartyReference;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FixedIncomeSecurityContentModelOnlyExistsValidator implements ValidatorWithArg<FixedIncomeSecurityContentModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FixedIncomeSecurityContentModel> ValidationResult<FixedIncomeSecurityContentModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("issuerName", ExistenceChecker.isSet((String) o.getIssuerName()))
				.put("issuerPartyReference", ExistenceChecker.isSet((PartyReference) o.getIssuerPartyReference()))
				.put("seniority", ExistenceChecker.isSet((CreditSeniority) o.getSeniority()))
				.put("couponType", ExistenceChecker.isSet((CouponType) o.getCouponType()))
				.put("couponRate", ExistenceChecker.isSet((BigDecimal) o.getCouponRate()))
				.put("maturity", ExistenceChecker.isSet((Date) o.getMaturity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FixedIncomeSecurityContentModel", ValidationType.ONLY_EXISTS, "FixedIncomeSecurityContentModel", path, "");
		}
		return failure("FixedIncomeSecurityContentModel", ValidationType.ONLY_EXISTS, "FixedIncomeSecurityContentModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
