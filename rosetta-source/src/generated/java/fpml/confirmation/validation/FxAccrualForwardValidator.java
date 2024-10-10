package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrual;
import fpml.confirmation.FxAccrualForward;
import fpml.confirmation.FxAccrualLinearPayoffRegion;
import fpml.confirmation.FxAccrualSettlementPeriodSchedule;
import fpml.confirmation.FxAverageRate;
import fpml.confirmation.FxCashSettlementSimple;
import fpml.confirmation.FxExpiryDateOrScheduleModel;
import fpml.confirmation.FxSettlementDateOrScheduleModel;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.ProductModel;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualForwardValidator implements Validator<FxAccrualForward> {

	private List<ComparisonResult> getComparisonResults(FxAccrualForward o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmount", (NonNegativeAmountSchedule) o.getNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("accrual", (FxAccrual) o.getAccrual() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxExpiryDateOrScheduleModel", (FxExpiryDateOrScheduleModel) o.getFxExpiryDateOrScheduleModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxSettlementDateOrScheduleModel", (FxSettlementDateOrScheduleModel) o.getFxSettlementDateOrScheduleModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("spotRate", (BigDecimal) o.getSpotRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("linearPayoffRegion", (List<? extends FxAccrualLinearPayoffRegion>) o.getLinearPayoffRegion() == null ? 0 : ((List<? extends FxAccrualLinearPayoffRegion>) o.getLinearPayoffRegion()).size(), 1, 0), 
				checkCardinality("averageRate", (FxAverageRate) o.getAverageRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlement", (FxCashSettlementSimple) o.getCashSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementPeriodSchedule", (FxAccrualSettlementPeriodSchedule) o.getSettlementPeriodSchedule() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxAccrualForward> validate(RosettaPath path, FxAccrualForward o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualForward", ValidationType.CARDINALITY, "FxAccrualForward", path, "", error);
		}
		return success("FxAccrualForward", ValidationType.CARDINALITY, "FxAccrualForward", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualForward o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualForward", ValidationType.CARDINALITY, "FxAccrualForward", path, "", res.getError());
				}
				return success("FxAccrualForward", ValidationType.CARDINALITY, "FxAccrualForward", path, "");
			})
			.collect(toList());
	}

}
