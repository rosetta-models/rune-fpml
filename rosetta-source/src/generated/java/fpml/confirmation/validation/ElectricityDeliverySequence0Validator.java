package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ElectricityDeliveryPoint;
import fpml.confirmation.ElectricityDeliverySequence0;
import fpml.confirmation.ElectricityDeliveryType;
import fpml.confirmation.ElectricityTransmissionContingency;
import fpml.confirmation.InterconnectionPoint;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ElectricityDeliverySequence0Validator implements Validator<ElectricityDeliverySequence0> {

	private List<ComparisonResult> getComparisonResults(ElectricityDeliverySequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("deliveryPoint", (ElectricityDeliveryPoint) o.getDeliveryPoint() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryType", (ElectricityDeliveryType) o.getDeliveryType() != null ? 1 : 0, 0, 1), 
				checkCardinality("transmissionContingency", (ElectricityTransmissionContingency) o.getTransmissionContingency() != null ? 1 : 0, 0, 1), 
				checkCardinality("interconnectionPoint", (InterconnectionPoint) o.getInterconnectionPoint() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ElectricityDeliverySequence0> validate(RosettaPath path, ElectricityDeliverySequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ElectricityDeliverySequence0", ValidationType.CARDINALITY, "ElectricityDeliverySequence0", path, "", error);
		}
		return success("ElectricityDeliverySequence0", ValidationType.CARDINALITY, "ElectricityDeliverySequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityDeliverySequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityDeliverySequence0", ValidationType.CARDINALITY, "ElectricityDeliverySequence0", path, "", res.getError());
				}
				return success("ElectricityDeliverySequence0", ValidationType.CARDINALITY, "ElectricityDeliverySequence0", path, "");
			})
			.collect(toList());
	}

}
