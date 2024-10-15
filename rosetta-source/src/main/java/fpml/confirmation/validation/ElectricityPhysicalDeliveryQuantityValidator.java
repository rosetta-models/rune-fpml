package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityQuantityFrequency;
import fpml.confirmation.ElectricityPhysicalDeliveryQuantity;
import fpml.confirmation.QuantityUnit;
import fpml.confirmation.SettlementPeriodsReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ElectricityPhysicalDeliveryQuantityValidator implements Validator<ElectricityPhysicalDeliveryQuantity> {

	private List<ComparisonResult> getComparisonResults(ElectricityPhysicalDeliveryQuantity o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("quantityUnit", (QuantityUnit) o.getQuantityUnit() != null ? 1 : 0, 1, 1), 
				checkCardinality("quantityFrequency", (CommodityQuantityFrequency) o.getQuantityFrequency() != null ? 1 : 0, 1, 1), 
				checkCardinality("quantity", (BigDecimal) o.getQuantity() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementPeriodsReference", (List<? extends SettlementPeriodsReference>) o.getSettlementPeriodsReference() == null ? 0 : ((List<? extends SettlementPeriodsReference>) o.getSettlementPeriodsReference()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<ElectricityPhysicalDeliveryQuantity> validate(RosettaPath path, ElectricityPhysicalDeliveryQuantity o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ElectricityPhysicalDeliveryQuantity", ValidationType.CARDINALITY, "ElectricityPhysicalDeliveryQuantity", path, "", error);
		}
		return success("ElectricityPhysicalDeliveryQuantity", ValidationType.CARDINALITY, "ElectricityPhysicalDeliveryQuantity", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityPhysicalDeliveryQuantity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityPhysicalDeliveryQuantity", ValidationType.CARDINALITY, "ElectricityPhysicalDeliveryQuantity", path, "", res.getError());
				}
				return success("ElectricityPhysicalDeliveryQuantity", ValidationType.CARDINALITY, "ElectricityPhysicalDeliveryQuantity", path, "");
			})
			.collect(toList());
	}

}
