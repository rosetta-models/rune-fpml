package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.ExerciseProcedure;
import fpml.confirmation.FxAccrual;
import fpml.confirmation.FxAccrualBarrier;
import fpml.confirmation.FxAccrualOption;
import fpml.confirmation.FxAccrualOptionSequence;
import fpml.confirmation.FxAverageRate;
import fpml.confirmation.FxAverageStrike;
import fpml.confirmation.FxExpiryDateOrScheduleModel;
import fpml.confirmation.FxOptionPremium;
import fpml.confirmation.FxSettlementDateOrScheduleModel;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.ProductModel;
import fpml.confirmation.PutCallCurrencyModel;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAccrualOptionOnlyExistsValidator implements ValidatorWithArg<FxAccrualOption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAccrualOption> ValidationResult<FxAccrualOption> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.put("putCallCurrencyModel", ExistenceChecker.isSet((PutCallCurrencyModel) o.getPutCallCurrencyModel()))
				.put("notionalAmount", ExistenceChecker.isSet((NonNegativeAmountSchedule) o.getNotionalAmount()))
				.put("accrual", ExistenceChecker.isSet((FxAccrual) o.getAccrual()))
				.put("fxExpiryDateOrScheduleModel", ExistenceChecker.isSet((FxExpiryDateOrScheduleModel) o.getFxExpiryDateOrScheduleModel()))
				.put("fxSettlementDateOrScheduleModel", ExistenceChecker.isSet((FxSettlementDateOrScheduleModel) o.getFxSettlementDateOrScheduleModel()))
				.put("exerciseProcedure", ExistenceChecker.isSet((ExerciseProcedure) o.getExerciseProcedure()))
				.put("spotRate", ExistenceChecker.isSet((BigDecimal) o.getSpotRate()))
				.put("fxAccrualOptionSequence", ExistenceChecker.isSet((FxAccrualOptionSequence) o.getFxAccrualOptionSequence()))
				.put("averageStrike", ExistenceChecker.isSet((FxAverageStrike) o.getAverageStrike()))
				.put("averageRate", ExistenceChecker.isSet((FxAverageRate) o.getAverageRate()))
				.put("barrier", ExistenceChecker.isSet((List<? extends FxAccrualBarrier>) o.getBarrier()))
				.put("premium", ExistenceChecker.isSet((List<? extends FxOptionPremium>) o.getPremium()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAccrualOption", ValidationType.ONLY_EXISTS, "FxAccrualOption", path, "");
		}
		return failure("FxAccrualOption", ValidationType.ONLY_EXISTS, "FxAccrualOption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
