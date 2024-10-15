package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DeliveryNearby;
import fpml.confirmation.DeliveryNearbyTypeEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DeliveryNearbyValidator implements Validator<DeliveryNearby> {

	private List<ComparisonResult> getComparisonResults(DeliveryNearby o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("deliveryNearbyMultiplier", (Integer) o.getDeliveryNearbyMultiplier() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryNearbyType", (DeliveryNearbyTypeEnum) o.getDeliveryNearbyType() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<DeliveryNearby> validate(RosettaPath path, DeliveryNearby o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DeliveryNearby", ValidationType.CARDINALITY, "DeliveryNearby", path, "", error);
		}
		return success("DeliveryNearby", ValidationType.CARDINALITY, "DeliveryNearby", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeliveryNearby o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DeliveryNearby", ValidationType.CARDINALITY, "DeliveryNearby", path, "", res.getError());
				}
				return success("DeliveryNearby", ValidationType.CARDINALITY, "DeliveryNearby", path, "");
			})
			.collect(toList());
	}

}
