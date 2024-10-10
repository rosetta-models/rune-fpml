package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.ExerciseProcedure;
import fpml.confirmation.FxAccrual;
import fpml.confirmation.FxAccrualOption;
import fpml.confirmation.FxAccrualOptionSequence;
import fpml.confirmation.FxAverageRate;
import fpml.confirmation.FxAverageStrike;
import fpml.confirmation.FxExpiryDateOrScheduleModel;
import fpml.confirmation.FxSettlementDateOrScheduleModel;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.ProductModel;
import fpml.confirmation.PutCallCurrencyModel;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualOptionValidator implements Validator<FxAccrualOption> {

	private List<ComparisonResult> getComparisonResults(FxAccrualOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("putCallCurrencyModel", (PutCallCurrencyModel) o.getPutCallCurrencyModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("notionalAmount", (NonNegativeAmountSchedule) o.getNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("accrual", (FxAccrual) o.getAccrual() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxExpiryDateOrScheduleModel", (FxExpiryDateOrScheduleModel) o.getFxExpiryDateOrScheduleModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxSettlementDateOrScheduleModel", (FxSettlementDateOrScheduleModel) o.getFxSettlementDateOrScheduleModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("exerciseProcedure", (ExerciseProcedure) o.getExerciseProcedure() != null ? 1 : 0, 0, 1), 
				checkCardinality("spotRate", (BigDecimal) o.getSpotRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxAccrualOptionSequence", (FxAccrualOptionSequence) o.getFxAccrualOptionSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("averageStrike", (FxAverageStrike) o.getAverageStrike() != null ? 1 : 0, 0, 1), 
				checkCardinality("averageRate", (FxAverageRate) o.getAverageRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxAccrualOption> validate(RosettaPath path, FxAccrualOption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualOption", ValidationType.CARDINALITY, "FxAccrualOption", path, "", error);
		}
		return success("FxAccrualOption", ValidationType.CARDINALITY, "FxAccrualOption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualOption", ValidationType.CARDINALITY, "FxAccrualOption", path, "", res.getError());
				}
				return success("FxAccrualOption", ValidationType.CARDINALITY, "FxAccrualOption", path, "");
			})
			.collect(toList());
	}

}
