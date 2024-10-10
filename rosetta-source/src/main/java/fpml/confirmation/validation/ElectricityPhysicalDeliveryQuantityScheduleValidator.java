package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityDeliveryPeriodsPointerModel;
import fpml.confirmation.CommodityNotionalQuantity;
import fpml.confirmation.ElectricityPhysicalDeliveryQuantitySchedule;
import fpml.confirmation.SettlementPeriodsReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ElectricityPhysicalDeliveryQuantityScheduleValidator implements Validator<ElectricityPhysicalDeliveryQuantitySchedule> {

	private List<ComparisonResult> getComparisonResults(ElectricityPhysicalDeliveryQuantitySchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("quantityStep", (List<? extends CommodityNotionalQuantity>) o.getQuantityStep() == null ? 0 : ((List<? extends CommodityNotionalQuantity>) o.getQuantityStep()).size(), 1, 0), 
				checkCardinality("commodityDeliveryPeriodsPointerModel", (CommodityDeliveryPeriodsPointerModel) o.getCommodityDeliveryPeriodsPointerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementPeriodsReference", (List<? extends SettlementPeriodsReference>) o.getSettlementPeriodsReference() == null ? 0 : ((List<? extends SettlementPeriodsReference>) o.getSettlementPeriodsReference()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<ElectricityPhysicalDeliveryQuantitySchedule> validate(RosettaPath path, ElectricityPhysicalDeliveryQuantitySchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ElectricityPhysicalDeliveryQuantitySchedule", ValidationType.CARDINALITY, "ElectricityPhysicalDeliveryQuantitySchedule", path, "", error);
		}
		return success("ElectricityPhysicalDeliveryQuantitySchedule", ValidationType.CARDINALITY, "ElectricityPhysicalDeliveryQuantitySchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityPhysicalDeliveryQuantitySchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ElectricityPhysicalDeliveryQuantitySchedule", ValidationType.CARDINALITY, "ElectricityPhysicalDeliveryQuantitySchedule", path, "", res.getError());
				}
				return success("ElectricityPhysicalDeliveryQuantitySchedule", ValidationType.CARDINALITY, "ElectricityPhysicalDeliveryQuantitySchedule", path, "");
			})
			.collect(toList());
	}

}
