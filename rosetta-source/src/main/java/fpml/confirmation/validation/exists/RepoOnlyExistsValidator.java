package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BondEquityModel;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FloatingRateCalculation;
import fpml.confirmation.InitialMargin;
import fpml.confirmation.ProductModel;
import fpml.confirmation.Repo;
import fpml.confirmation.RepoDurationEnum;
import fpml.confirmation.RepoFarLeg;
import fpml.confirmation.RepoNearLeg;
import fpml.confirmation.RepoSequence;
import fpml.confirmation.Schedule;
import fpml.confirmation.TriParty;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RepoOnlyExistsValidator implements ValidatorWithArg<Repo, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Repo> ValidationResult<Repo> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("fixedRateSchedule", ExistenceChecker.isSet((Schedule) o.getFixedRateSchedule()))
				.put("floatingRateCalculation", ExistenceChecker.isSet((FloatingRateCalculation) o.getFloatingRateCalculation()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("duration", ExistenceChecker.isSet((RepoDurationEnum) o.getDuration()))
				.put("repoSequence", ExistenceChecker.isSet((RepoSequence) o.getRepoSequence()))
				.put("initialMargin", ExistenceChecker.isSet((InitialMargin) o.getInitialMargin()))
				.put("nearLeg", ExistenceChecker.isSet((RepoNearLeg) o.getNearLeg()))
				.put("farLeg", ExistenceChecker.isSet((RepoFarLeg) o.getFarLeg()))
				.put("bondEquityModel", ExistenceChecker.isSet((List<? extends BondEquityModel>) o.getBondEquityModel()))
				.put("triParty", ExistenceChecker.isSet((TriParty) o.getTriParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Repo", ValidationType.ONLY_EXISTS, "Repo", path, "");
		}
		return failure("Repo", ValidationType.ONLY_EXISTS, "Repo", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
