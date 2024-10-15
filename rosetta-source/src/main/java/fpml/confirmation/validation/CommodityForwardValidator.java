package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.AveragePriceLeg;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommodityForward;
import fpml.confirmation.CommodityForwardLeg;
import fpml.confirmation.NonPeriodicFixedPriceLeg;
import fpml.confirmation.ProductModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityForwardValidator implements Validator<CommodityForward> {

	private List<ComparisonResult> getComparisonResults(CommodityForward o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("valueDate", (AdjustableOrRelativeDate) o.getValueDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedLeg", (NonPeriodicFixedPriceLeg) o.getFixedLeg() != null ? 1 : 0, 0, 1), 
				checkCardinality("averagePriceLeg", (AveragePriceLeg) o.getAveragePriceLeg() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityForwardLeg", (CommodityForwardLeg) o.getCommodityForwardLeg() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityContentModel", (CommodityContentModel) o.getCommodityContentModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityForward> validate(RosettaPath path, CommodityForward o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityForward", ValidationType.CARDINALITY, "CommodityForward", path, "", error);
		}
		return success("CommodityForward", ValidationType.CARDINALITY, "CommodityForward", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityForward o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityForward", ValidationType.CARDINALITY, "CommodityForward", path, "", res.getError());
				}
				return success("CommodityForward", ValidationType.CARDINALITY, "CommodityForward", path, "");
			})
			.collect(toList());
	}

}
