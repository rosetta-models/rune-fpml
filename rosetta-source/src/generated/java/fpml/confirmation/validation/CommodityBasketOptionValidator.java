package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.CommodityBasketModel;
import fpml.confirmation.CommodityBasketOption;
import fpml.confirmation.CommodityBasketOptionFeaturesModel;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommodityExerciseBasket;
import fpml.confirmation.CommodityFloatingStrikePriceModel;
import fpml.confirmation.CommodityPremium;
import fpml.confirmation.CommodityStrikePriceModel;
import fpml.confirmation.ProductModel;
import fpml.confirmation.PutCallEnum;
import fpml.confirmation.StrikePriceBasketReference;
import fpml.confirmation.StrikePriceUnderlyingReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityBasketOptionValidator implements Validator<CommodityBasketOption> {

	private List<ComparisonResult> getComparisonResults(CommodityBasketOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("optionType", (PutCallEnum) o.getOptionType() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityBasketOptionFeaturesModel", (CommodityBasketOptionFeaturesModel) o.getCommodityBasketOptionFeaturesModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityBasketModel", (CommodityBasketModel) o.getCommodityBasketModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("strikePriceUnderlyingReference", (StrikePriceUnderlyingReference) o.getStrikePriceUnderlyingReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikePriceBasketReference", (StrikePriceBasketReference) o.getStrikePriceBasketReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityStrikePriceModel", (CommodityStrikePriceModel) o.getCommodityStrikePriceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityFloatingStrikePriceModel", (CommodityFloatingStrikePriceModel) o.getCommodityFloatingStrikePriceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("exercise", (CommodityExerciseBasket) o.getExercise() != null ? 1 : 0, 1, 1), 
				checkCardinality("premium", (List<? extends CommodityPremium>) o.getPremium() == null ? 0 : ((List<? extends CommodityPremium>) o.getPremium()).size(), 1, 0), 
				checkCardinality("commodityContentModel", (CommodityContentModel) o.getCommodityContentModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityBasketOption> validate(RosettaPath path, CommodityBasketOption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityBasketOption", ValidationType.CARDINALITY, "CommodityBasketOption", path, "", error);
		}
		return success("CommodityBasketOption", ValidationType.CARDINALITY, "CommodityBasketOption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasketOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBasketOption", ValidationType.CARDINALITY, "CommodityBasketOption", path, "", res.getError());
				}
				return success("CommodityBasketOption", ValidationType.CARDINALITY, "CommodityBasketOption", path, "");
			})
			.collect(toList());
	}

}
