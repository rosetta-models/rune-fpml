package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrual;
import fpml.confirmation.FxAccrualBarrier;
import fpml.confirmation.FxAccrualForward;
import fpml.confirmation.FxAccrualLinearPayoffRegion;
import fpml.confirmation.FxAccrualSettlementPeriodSchedule;
import fpml.confirmation.FxAverageRate;
import fpml.confirmation.FxCashSettlementSimple;
import fpml.confirmation.FxExpiryDateOrScheduleModel;
import fpml.confirmation.FxSettlementDateOrScheduleModel;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.ProductModel;
import fpml.confirmation.SimplePayment;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAccrualForwardOnlyExistsValidator implements ValidatorWithArg<FxAccrualForward, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAccrualForward> ValidationResult<FxAccrualForward> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("notionalAmount", ExistenceChecker.isSet((NonNegativeAmountSchedule) o.getNotionalAmount()))
				.put("accrual", ExistenceChecker.isSet((FxAccrual) o.getAccrual()))
				.put("fxExpiryDateOrScheduleModel", ExistenceChecker.isSet((FxExpiryDateOrScheduleModel) o.getFxExpiryDateOrScheduleModel()))
				.put("fxSettlementDateOrScheduleModel", ExistenceChecker.isSet((FxSettlementDateOrScheduleModel) o.getFxSettlementDateOrScheduleModel()))
				.put("spotRate", ExistenceChecker.isSet((BigDecimal) o.getSpotRate()))
				.put("linearPayoffRegion", ExistenceChecker.isSet((List<? extends FxAccrualLinearPayoffRegion>) o.getLinearPayoffRegion()))
				.put("averageRate", ExistenceChecker.isSet((FxAverageRate) o.getAverageRate()))
				.put("barrier", ExistenceChecker.isSet((List<? extends FxAccrualBarrier>) o.getBarrier()))
				.put("additionalPayment", ExistenceChecker.isSet((List<? extends SimplePayment>) o.getAdditionalPayment()))
				.put("cashSettlement", ExistenceChecker.isSet((FxCashSettlementSimple) o.getCashSettlement()))
				.put("settlementPeriodSchedule", ExistenceChecker.isSet((FxAccrualSettlementPeriodSchedule) o.getSettlementPeriodSchedule()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAccrualForward", ValidationType.ONLY_EXISTS, "FxAccrualForward", path, "");
		}
		return failure("FxAccrualForward", ValidationType.ONLY_EXISTS, "FxAccrualForward", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
