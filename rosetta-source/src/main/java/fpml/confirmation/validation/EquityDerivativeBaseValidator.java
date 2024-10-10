package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.EquityDerivativeBase;
import fpml.confirmation.EquityExerciseValuationSettlement;
import fpml.confirmation.EquityOptionTypeEnum;
import fpml.confirmation.FeatureModel;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.ProductModel;
import fpml.confirmation.StrategyFeature;
import fpml.confirmation.Underlyer;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquityDerivativeBaseValidator implements Validator<EquityDerivativeBase> {

	private List<ComparisonResult> getComparisonResults(EquityDerivativeBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("optionType", (EquityOptionTypeEnum) o.getOptionType() != null ? 1 : 0, 1, 1), 
				checkCardinality("equityEffectiveDate", (Date) o.getEquityEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyer", (Underlyer) o.getUnderlyer() != null ? 1 : 0, 1, 1), 
				checkCardinality("notional", (NonNegativeMoney) o.getNotional() != null ? 1 : 0, 0, 1), 
				checkCardinality("equityExercise", (EquityExerciseValuationSettlement) o.getEquityExercise() != null ? 1 : 0, 1, 1), 
				checkCardinality("featureModel", (FeatureModel) o.getFeatureModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("strategyFeature", (StrategyFeature) o.getStrategyFeature() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<EquityDerivativeBase> validate(RosettaPath path, EquityDerivativeBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquityDerivativeBase", ValidationType.CARDINALITY, "EquityDerivativeBase", path, "", error);
		}
		return success("EquityDerivativeBase", ValidationType.CARDINALITY, "EquityDerivativeBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityDerivativeBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityDerivativeBase", ValidationType.CARDINALITY, "EquityDerivativeBase", path, "", res.getError());
				}
				return success("EquityDerivativeBase", ValidationType.CARDINALITY, "EquityDerivativeBase", path, "");
			})
			.collect(toList());
	}

}
