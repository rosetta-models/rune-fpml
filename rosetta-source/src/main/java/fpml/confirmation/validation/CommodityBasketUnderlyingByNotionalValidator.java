package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AveragingMethodEnum;
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityBasketUnderlyingByNotional;
import fpml.confirmation.CommodityFx;
import fpml.confirmation.CommodityNotionalQuantityModel;
import fpml.confirmation.CommodityPricingDates;
import fpml.confirmation.PayerReceiverEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityBasketUnderlyingByNotionalValidator implements Validator<CommodityBasketUnderlyingByNotional> {

	private List<ComparisonResult> getComparisonResults(CommodityBasketUnderlyingByNotional o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("direction", (PayerReceiverEnum) o.getDirection() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodity", (Commodity) o.getCommodity() != null ? 1 : 0, 1, 1), 
				checkCardinality("pricingDates", (CommodityPricingDates) o.getPricingDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("averagingMethod", (AveragingMethodEnum) o.getAveragingMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("fx", (CommodityFx) o.getFx() != null ? 1 : 0, 0, 1), 
				checkCardinality("conversionFactor", (BigDecimal) o.getConversionFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityNotionalQuantityModel", (CommodityNotionalQuantityModel) o.getCommodityNotionalQuantityModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommodityBasketUnderlyingByNotional> validate(RosettaPath path, CommodityBasketUnderlyingByNotional o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityBasketUnderlyingByNotional", ValidationType.CARDINALITY, "CommodityBasketUnderlyingByNotional", path, "", error);
		}
		return success("CommodityBasketUnderlyingByNotional", ValidationType.CARDINALITY, "CommodityBasketUnderlyingByNotional", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasketUnderlyingByNotional o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBasketUnderlyingByNotional", ValidationType.CARDINALITY, "CommodityBasketUnderlyingByNotional", path, "", res.getError());
				}
				return success("CommodityBasketUnderlyingByNotional", ValidationType.CARDINALITY, "CommodityBasketUnderlyingByNotional", path, "");
			})
			.collect(toList());
	}

}
