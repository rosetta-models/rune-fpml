package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.ExerciseProcedure;
import fpml.confirmation.FxAmericanExercise;
import fpml.confirmation.FxCashSettlement;
import fpml.confirmation.FxEuropeanExercise;
import fpml.confirmation.FxOption;
import fpml.confirmation.FxOptionFeatures;
import fpml.confirmation.FxOptionPremium;
import fpml.confirmation.FxStrikePrice;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.Period;
import fpml.confirmation.ProductModel;
import fpml.confirmation.PutCallEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxOptionValidator implements Validator<FxOption> {

	private List<ComparisonResult> getComparisonResults(FxOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("tenorPeriod", (Period) o.getTenorPeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("americanExercise", (FxAmericanExercise) o.getAmericanExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("europeanExercise", (FxEuropeanExercise) o.getEuropeanExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseProcedure", (ExerciseProcedure) o.getExerciseProcedure() != null ? 1 : 0, 0, 1), 
				checkCardinality("putCurrencyAmount", (NonNegativeMoney) o.getPutCurrencyAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("callCurrencyAmount", (NonNegativeMoney) o.getCallCurrencyAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("soldAs", (PutCallEnum) o.getSoldAs() != null ? 1 : 0, 0, 1), 
				checkCardinality("strike", (FxStrikePrice) o.getStrike() != null ? 1 : 0, 1, 1), 
				checkCardinality("spotRate", (BigDecimal) o.getSpotRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("features", (FxOptionFeatures) o.getFeatures() != null ? 1 : 0, 0, 1), 
				checkCardinality("premium", (FxOptionPremium) o.getPremium() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlement", (FxCashSettlement) o.getCashSettlement() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxOption> validate(RosettaPath path, FxOption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxOption", ValidationType.CARDINALITY, "FxOption", path, "", error);
		}
		return success("FxOption", ValidationType.CARDINALITY, "FxOption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxOption", ValidationType.CARDINALITY, "FxOption", path, "", res.getError());
				}
				return success("FxOption", ValidationType.CARDINALITY, "FxOption", path, "");
			})
			.collect(toList());
	}

}
