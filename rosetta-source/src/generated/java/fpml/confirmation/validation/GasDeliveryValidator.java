package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityDeliveryPointsModel;
import fpml.confirmation.DeliveryTypeEnum;
import fpml.confirmation.GasDelivery;
import fpml.confirmation.GasDeliverySequence;
import fpml.confirmation.InterconnectionPoint;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GasDeliveryValidator implements Validator<GasDelivery> {

	private List<ComparisonResult> getComparisonResults(GasDelivery o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commodityDeliveryPointsModel", (CommodityDeliveryPointsModel) o.getCommodityDeliveryPointsModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryType", (DeliveryTypeEnum) o.getDeliveryType() != null ? 1 : 0, 1, 1), 
				checkCardinality("interconnectionPoint", (InterconnectionPoint) o.getInterconnectionPoint() != null ? 1 : 0, 0, 1), 
				checkCardinality("gasDeliverySequence", (GasDeliverySequence) o.getGasDeliverySequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<GasDelivery> validate(RosettaPath path, GasDelivery o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GasDelivery", ValidationType.CARDINALITY, "GasDelivery", path, "", error);
		}
		return success("GasDelivery", ValidationType.CARDINALITY, "GasDelivery", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GasDelivery o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GasDelivery", ValidationType.CARDINALITY, "GasDelivery", path, "", res.getError());
				}
				return success("GasDelivery", ValidationType.CARDINALITY, "GasDelivery", path, "");
			})
			.collect(toList());
	}

}
