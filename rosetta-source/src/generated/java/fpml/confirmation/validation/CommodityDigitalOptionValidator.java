package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommodityDigitalExercise;
import fpml.confirmation.CommodityDigitalOption;
import fpml.confirmation.CommodityDigitalOptionFeaturesModel;
import fpml.confirmation.CommodityDigitalOptionSequence;
import fpml.confirmation.CommodityPremium;
import fpml.confirmation.NotionalAmount;
import fpml.confirmation.ProductModel;
import fpml.confirmation.PutCallEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityDigitalOptionValidator implements Validator<CommodityDigitalOption> {

	private List<ComparisonResult> getComparisonResults(CommodityDigitalOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("optionType", (PutCallEnum) o.getOptionType() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodity", (Commodity) o.getCommodity() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityDigitalOptionFeaturesModel", (CommodityDigitalOptionFeaturesModel) o.getCommodityDigitalOptionFeaturesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("notionalAmount", (NotionalAmount) o.getNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityDigitalOptionSequence", (CommodityDigitalOptionSequence) o.getCommodityDigitalOptionSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("exercise", (CommodityDigitalExercise) o.getExercise() != null ? 1 : 0, 1, 1), 
				checkCardinality("premium", (List<? extends CommodityPremium>) o.getPremium() == null ? 0 : ((List<? extends CommodityPremium>) o.getPremium()).size(), 1, 0), 
				checkCardinality("commodityContentModel", (CommodityContentModel) o.getCommodityContentModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityDigitalOption> validate(RosettaPath path, CommodityDigitalOption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityDigitalOption", ValidationType.CARDINALITY, "CommodityDigitalOption", path, "", error);
		}
		return success("CommodityDigitalOption", ValidationType.CARDINALITY, "CommodityDigitalOption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDigitalOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityDigitalOption", ValidationType.CARDINALITY, "CommodityDigitalOption", path, "", res.getError());
				}
				return success("CommodityDigitalOption", ValidationType.CARDINALITY, "CommodityDigitalOption", path, "");
			})
			.collect(toList());
	}

}
