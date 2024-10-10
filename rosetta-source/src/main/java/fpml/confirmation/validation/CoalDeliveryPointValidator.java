package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CoalDeliveryPoint;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CoalDeliveryPointValidator implements Validator<CoalDeliveryPoint> {

	private List<ComparisonResult> getComparisonResults(CoalDeliveryPoint o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryPointScheme", (String) o.getDeliveryPointScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CoalDeliveryPoint> validate(RosettaPath path, CoalDeliveryPoint o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CoalDeliveryPoint", ValidationType.CARDINALITY, "CoalDeliveryPoint", path, "", error);
		}
		return success("CoalDeliveryPoint", ValidationType.CARDINALITY, "CoalDeliveryPoint", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalDeliveryPoint o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CoalDeliveryPoint", ValidationType.CARDINALITY, "CoalDeliveryPoint", path, "", res.getError());
				}
				return success("CoalDeliveryPoint", ValidationType.CARDINALITY, "CoalDeliveryPoint", path, "");
			})
			.collect(toList());
	}

}
