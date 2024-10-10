package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityDeliveryPoint;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityDeliveryPointValidator implements Validator<CommodityDeliveryPoint> {

	private List<ComparisonResult> getComparisonResults(CommodityDeliveryPoint o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryPointScheme", (String) o.getDeliveryPointScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityDeliveryPoint> validate(RosettaPath path, CommodityDeliveryPoint o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityDeliveryPoint", ValidationType.CARDINALITY, "CommodityDeliveryPoint", path, "", error);
		}
		return success("CommodityDeliveryPoint", ValidationType.CARDINALITY, "CommodityDeliveryPoint", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDeliveryPoint o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityDeliveryPoint", ValidationType.CARDINALITY, "CommodityDeliveryPoint", path, "", res.getError());
				}
				return success("CommodityDeliveryPoint", ValidationType.CARDINALITY, "CommodityDeliveryPoint", path, "");
			})
			.collect(toList());
	}

}
