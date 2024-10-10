package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityDeliveryPoint;
import fpml.confirmation.CommodityDeliveryRisk;
import fpml.confirmation.MetalDelivery;
import fpml.confirmation.MetalTitleEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MetalDeliveryValidator implements Validator<MetalDelivery> {

	private List<ComparisonResult> getComparisonResults(MetalDelivery o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("deliveryLocation", (CommodityDeliveryPoint) o.getDeliveryLocation() != null ? 1 : 0, 1, 1), 
				checkCardinality("risk", (CommodityDeliveryRisk) o.getRisk() != null ? 1 : 0, 0, 1), 
				checkCardinality("totalQuantityTolerance", (BigDecimal) o.getTotalQuantityTolerance() != null ? 1 : 0, 1, 1), 
				checkCardinality("periodQuantityTolerance", (BigDecimal) o.getPeriodQuantityTolerance() != null ? 1 : 0, 1, 1), 
				checkCardinality("title", (MetalTitleEnum) o.getTitle() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<MetalDelivery> validate(RosettaPath path, MetalDelivery o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MetalDelivery", ValidationType.CARDINALITY, "MetalDelivery", path, "", error);
		}
		return success("MetalDelivery", ValidationType.CARDINALITY, "MetalDelivery", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MetalDelivery o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MetalDelivery", ValidationType.CARDINALITY, "MetalDelivery", path, "", res.getError());
				}
				return success("MetalDelivery", ValidationType.CARDINALITY, "MetalDelivery", path, "");
			})
			.collect(toList());
	}

}
