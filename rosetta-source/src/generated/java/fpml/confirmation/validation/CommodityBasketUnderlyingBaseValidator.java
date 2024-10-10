package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AveragingMethodEnum;
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityBasketUnderlyingBase;
import fpml.confirmation.CommodityPricingDates;
import fpml.confirmation.PayerReceiverEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityBasketUnderlyingBaseValidator implements Validator<CommodityBasketUnderlyingBase> {

	private List<ComparisonResult> getComparisonResults(CommodityBasketUnderlyingBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("direction", (PayerReceiverEnum) o.getDirection() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodity", (Commodity) o.getCommodity() != null ? 1 : 0, 1, 1), 
				checkCardinality("pricingDates", (CommodityPricingDates) o.getPricingDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("averagingMethod", (AveragingMethodEnum) o.getAveragingMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityBasketUnderlyingBase> validate(RosettaPath path, CommodityBasketUnderlyingBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityBasketUnderlyingBase", ValidationType.CARDINALITY, "CommodityBasketUnderlyingBase", path, "", error);
		}
		return success("CommodityBasketUnderlyingBase", ValidationType.CARDINALITY, "CommodityBasketUnderlyingBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasketUnderlyingBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBasketUnderlyingBase", ValidationType.CARDINALITY, "CommodityBasketUnderlyingBase", path, "", res.getError());
				}
				return success("CommodityBasketUnderlyingBase", ValidationType.CARDINALITY, "CommodityBasketUnderlyingBase", path, "");
			})
			.collect(toList());
	}

}
