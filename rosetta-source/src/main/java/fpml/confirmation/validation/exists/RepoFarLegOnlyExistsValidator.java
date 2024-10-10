package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.FxRate;
import fpml.confirmation.RepoFarLeg;
import fpml.confirmation.RepoFarLegSequence;
import fpml.confirmation.SettlementAmountOrCurrencyModel;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RepoFarLegOnlyExistsValidator implements ValidatorWithArg<RepoFarLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RepoFarLeg> ValidationResult<RepoFarLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("settlementDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getSettlementDate()))
				.put("settlementAmountOrCurrencyModel", ExistenceChecker.isSet((SettlementAmountOrCurrencyModel) o.getSettlementAmountOrCurrencyModel()))
				.put("fxRate", ExistenceChecker.isSet((FxRate) o.getFxRate()))
				.put("repoFarLegSequence", ExistenceChecker.isSet((RepoFarLegSequence) o.getRepoFarLegSequence()))
				.put("repoInterest", ExistenceChecker.isSet((BigDecimal) o.getRepoInterest()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RepoFarLeg", ValidationType.ONLY_EXISTS, "RepoFarLeg", path, "");
		}
		return failure("RepoFarLeg", ValidationType.ONLY_EXISTS, "RepoFarLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
