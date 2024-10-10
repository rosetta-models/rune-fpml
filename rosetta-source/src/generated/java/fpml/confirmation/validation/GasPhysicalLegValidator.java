package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GasDelivery;
import fpml.confirmation.GasDeliveryPeriods;
import fpml.confirmation.GasPhysicalLeg;
import fpml.confirmation.GasPhysicalQuantity;
import fpml.confirmation.GasProduct;
import fpml.confirmation.PayerReceiverModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GasPhysicalLegValidator implements Validator<GasPhysicalLeg> {

	private List<ComparisonResult> getComparisonResults(GasPhysicalLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryPeriods", (GasDeliveryPeriods) o.getDeliveryPeriods() != null ? 1 : 0, 1, 1), 
				checkCardinality("gas", (GasProduct) o.getGas() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryConditions", (GasDelivery) o.getDeliveryConditions() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryQuantity", (GasPhysicalQuantity) o.getDeliveryQuantity() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<GasPhysicalLeg> validate(RosettaPath path, GasPhysicalLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GasPhysicalLeg", ValidationType.CARDINALITY, "GasPhysicalLeg", path, "", error);
		}
		return success("GasPhysicalLeg", ValidationType.CARDINALITY, "GasPhysicalLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GasPhysicalLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GasPhysicalLeg", ValidationType.CARDINALITY, "GasPhysicalLeg", path, "", res.getError());
				}
				return success("GasPhysicalLeg", ValidationType.CARDINALITY, "GasPhysicalLeg", path, "");
			})
			.collect(toList());
	}

}
