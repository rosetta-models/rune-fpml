package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrAdjustedDate;
import fpml.confirmation.Currency;
import fpml.confirmation.ExerciseProcedure;
import fpml.confirmation.FxCashSettlementSimple;
import fpml.confirmation.FxEuropeanExercise;
import fpml.confirmation.FxStraddle;
import fpml.confirmation.FxStraddlePremium;
import fpml.confirmation.FxStraddleTypeEnum;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.Period;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxStraddleOnlyExistsValidator implements ValidatorWithArg<FxStraddle, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxStraddle> ValidationResult<FxStraddle> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("straddleType", ExistenceChecker.isSet((FxStraddleTypeEnum) o.getStraddleType()))
				.put("tenorPeriod", ExistenceChecker.isSet((Period) o.getTenorPeriod()))
				.put("europeanExercise", ExistenceChecker.isSet((FxEuropeanExercise) o.getEuropeanExercise()))
				.put("exerciseProcedure", ExistenceChecker.isSet((ExerciseProcedure) o.getExerciseProcedure()))
				.put("notional", ExistenceChecker.isSet((NonNegativeMoney) o.getNotional()))
				.put("counterCurrency", ExistenceChecker.isSet((Currency) o.getCounterCurrency()))
				.put("premium", ExistenceChecker.isSet((List<? extends FxStraddlePremium>) o.getPremium()))
				.put("settlementDate", ExistenceChecker.isSet((AdjustableOrAdjustedDate) o.getSettlementDate()))
				.put("cashSettlement", ExistenceChecker.isSet((FxCashSettlementSimple) o.getCashSettlement()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxStraddle", ValidationType.ONLY_EXISTS, "FxStraddle", path, "");
		}
		return failure("FxStraddle", ValidationType.ONLY_EXISTS, "FxStraddle", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
