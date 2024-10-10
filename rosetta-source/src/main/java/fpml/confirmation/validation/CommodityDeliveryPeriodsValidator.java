package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommodityCalculationPeriodsSchedule;
import fpml.confirmation.CommodityDeliveryPeriods;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityDeliveryPeriodsValidator implements Validator<CommodityDeliveryPeriods> {

	private List<ComparisonResult> getComparisonResults(CommodityDeliveryPeriods o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("periods", (AdjustableDates) o.getPeriods() != null ? 1 : 0, 0, 1), 
				checkCardinality("periodsSchedule", (CommodityCalculationPeriodsSchedule) o.getPeriodsSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityCalculationPeriodsPointerModel", (CommodityCalculationPeriodsPointerModel) o.getCommodityCalculationPeriodsPointerModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityDeliveryPeriods> validate(RosettaPath path, CommodityDeliveryPeriods o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityDeliveryPeriods", ValidationType.CARDINALITY, "CommodityDeliveryPeriods", path, "", error);
		}
		return success("CommodityDeliveryPeriods", ValidationType.CARDINALITY, "CommodityDeliveryPeriods", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDeliveryPeriods o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityDeliveryPeriods", ValidationType.CARDINALITY, "CommodityDeliveryPeriods", path, "", res.getError());
				}
				return success("CommodityDeliveryPeriods", ValidationType.CARDINALITY, "CommodityDeliveryPeriods", path, "");
			})
			.collect(toList());
	}

}
