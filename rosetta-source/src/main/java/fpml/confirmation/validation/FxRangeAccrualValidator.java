package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrual;
import fpml.confirmation.FxExpiryDateOrScheduleModel;
import fpml.confirmation.FxRangeAccrual;
import fpml.confirmation.FxSettlementDateOrScheduleModel;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.ProductModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxRangeAccrualValidator implements Validator<FxRangeAccrual> {

	private List<ComparisonResult> getComparisonResults(FxRangeAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("notionalAmount", (NonNegativeAmountSchedule) o.getNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("accrual", (FxAccrual) o.getAccrual() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxExpiryDateOrScheduleModel", (FxExpiryDateOrScheduleModel) o.getFxExpiryDateOrScheduleModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxSettlementDateOrScheduleModel", (FxSettlementDateOrScheduleModel) o.getFxSettlementDateOrScheduleModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxRangeAccrual> validate(RosettaPath path, FxRangeAccrual o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxRangeAccrual", ValidationType.CARDINALITY, "FxRangeAccrual", path, "", error);
		}
		return success("FxRangeAccrual", ValidationType.CARDINALITY, "FxRangeAccrual", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxRangeAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxRangeAccrual", ValidationType.CARDINALITY, "FxRangeAccrual", path, "", res.getError());
				}
				return success("FxRangeAccrual", ValidationType.CARDINALITY, "FxRangeAccrual", path, "");
			})
			.collect(toList());
	}

}
