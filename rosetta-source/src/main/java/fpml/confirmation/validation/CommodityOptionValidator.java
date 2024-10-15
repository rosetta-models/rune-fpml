package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommodityFinancialOptionModel;
import fpml.confirmation.CommodityOption;
import fpml.confirmation.CommodityPhysicalOptionModel;
import fpml.confirmation.CommodityPremium;
import fpml.confirmation.CommodityWeatherOptionModel;
import fpml.confirmation.ProductModel;
import fpml.confirmation.PutCallEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityOptionValidator implements Validator<CommodityOption> {

	private List<ComparisonResult> getComparisonResults(CommodityOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("optionType", (PutCallEnum) o.getOptionType() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityFinancialOptionModel", (CommodityFinancialOptionModel) o.getCommodityFinancialOptionModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityPhysicalOptionModel", (CommodityPhysicalOptionModel) o.getCommodityPhysicalOptionModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityWeatherOptionModel", (CommodityWeatherOptionModel) o.getCommodityWeatherOptionModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("premium", (List<? extends CommodityPremium>) o.getPremium() == null ? 0 : ((List<? extends CommodityPremium>) o.getPremium()).size(), 1, 0), 
				checkCardinality("commodityContentModel", (CommodityContentModel) o.getCommodityContentModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityOption> validate(RosettaPath path, CommodityOption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityOption", ValidationType.CARDINALITY, "CommodityOption", path, "", error);
		}
		return success("CommodityOption", ValidationType.CARDINALITY, "CommodityOption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityOption", ValidationType.CARDINALITY, "CommodityOption", path, "", res.getError());
				}
				return success("CommodityOption", ValidationType.CARDINALITY, "CommodityOption", path, "");
			})
			.collect(toList());
	}

}
