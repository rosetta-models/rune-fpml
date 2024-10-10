package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AveragingMethodEnum;
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityFx;
import fpml.confirmation.CommodityPricingDates;
import fpml.confirmation.CommoditySpread;
import fpml.confirmation.FloatingStrikePrice;
import fpml.confirmation.Rounding;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FloatingStrikePriceValidator implements Validator<FloatingStrikePrice> {

	private List<ComparisonResult> getComparisonResults(FloatingStrikePrice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("pricingDates", (CommodityPricingDates) o.getPricingDates() != null ? 1 : 0, 1, 1), 
				checkCardinality("averagingMethod", (AveragingMethodEnum) o.getAveragingMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("conversionFactor", (BigDecimal) o.getConversionFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("rounding", (Rounding) o.getRounding() != null ? 1 : 0, 0, 1), 
				checkCardinality("spread", (CommoditySpread) o.getSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("spreadPercentage", (BigDecimal) o.getSpreadPercentage() != null ? 1 : 0, 0, 1), 
				checkCardinality("fx", (CommodityFx) o.getFx() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodity", (Commodity) o.getCommodity() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FloatingStrikePrice> validate(RosettaPath path, FloatingStrikePrice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FloatingStrikePrice", ValidationType.CARDINALITY, "FloatingStrikePrice", path, "", error);
		}
		return success("FloatingStrikePrice", ValidationType.CARDINALITY, "FloatingStrikePrice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingStrikePrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingStrikePrice", ValidationType.CARDINALITY, "FloatingStrikePrice", path, "", res.getError());
				}
				return success("FloatingStrikePrice", ValidationType.CARDINALITY, "FloatingStrikePrice", path, "");
			})
			.collect(toList());
	}

}
