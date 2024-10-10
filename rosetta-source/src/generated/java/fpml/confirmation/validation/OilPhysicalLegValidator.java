package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityDeliveryPeriods;
import fpml.confirmation.CommodityPhysicalQuantity;
import fpml.confirmation.OilDelivery;
import fpml.confirmation.OilPhysicalLeg;
import fpml.confirmation.OilProduct;
import fpml.confirmation.PayerReceiverModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OilPhysicalLegValidator implements Validator<OilPhysicalLeg> {

	private List<ComparisonResult> getComparisonResults(OilPhysicalLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryPeriods", (CommodityDeliveryPeriods) o.getDeliveryPeriods() != null ? 1 : 0, 1, 1), 
				checkCardinality("oil", (OilProduct) o.getOil() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryConditions", (OilDelivery) o.getDeliveryConditions() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryQuantity", (CommodityPhysicalQuantity) o.getDeliveryQuantity() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<OilPhysicalLeg> validate(RosettaPath path, OilPhysicalLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OilPhysicalLeg", ValidationType.CARDINALITY, "OilPhysicalLeg", path, "", error);
		}
		return success("OilPhysicalLeg", ValidationType.CARDINALITY, "OilPhysicalLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OilPhysicalLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OilPhysicalLeg", ValidationType.CARDINALITY, "OilPhysicalLeg", path, "", res.getError());
				}
				return success("OilPhysicalLeg", ValidationType.CARDINALITY, "OilPhysicalLeg", path, "");
			})
			.collect(toList());
	}

}
