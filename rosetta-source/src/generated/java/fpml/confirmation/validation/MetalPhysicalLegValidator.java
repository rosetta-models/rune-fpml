package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityDeliveryPeriods;
import fpml.confirmation.CommodityFixedPhysicalQuantityModel;
import fpml.confirmation.Metal;
import fpml.confirmation.MetalDelivery;
import fpml.confirmation.MetalPhysicalLeg;
import fpml.confirmation.PayerReceiverModel;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MetalPhysicalLegValidator implements Validator<MetalPhysicalLeg> {

	private List<ComparisonResult> getComparisonResults(MetalPhysicalLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("metal", (Metal) o.getMetal() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryPeriods", (CommodityDeliveryPeriods) o.getDeliveryPeriods() != null ? 1 : 0, 1, 1), 
				checkCardinality("deliveryConditions", (MetalDelivery) o.getDeliveryConditions() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityFixedPhysicalQuantityModel", (CommodityFixedPhysicalQuantityModel) o.getCommodityFixedPhysicalQuantityModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("conversionFactor", (BigDecimal) o.getConversionFactor() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<MetalPhysicalLeg> validate(RosettaPath path, MetalPhysicalLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MetalPhysicalLeg", ValidationType.CARDINALITY, "MetalPhysicalLeg", path, "", error);
		}
		return success("MetalPhysicalLeg", ValidationType.CARDINALITY, "MetalPhysicalLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MetalPhysicalLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MetalPhysicalLeg", ValidationType.CARDINALITY, "MetalPhysicalLeg", path, "", res.getError());
				}
				return success("MetalPhysicalLeg", ValidationType.CARDINALITY, "MetalPhysicalLeg", path, "");
			})
			.collect(toList());
	}

}
