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
import fpml.confirmation.GasDeliveryPeriods;
import fpml.confirmation.GasDeliveryPeriodsSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GasDeliveryPeriodsValidator implements Validator<GasDeliveryPeriods> {

	private List<ComparisonResult> getComparisonResults(GasDeliveryPeriods o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("periods", (AdjustableDates) o.getPeriods() != null ? 1 : 0, 0, 1), 
				checkCardinality("periodsSchedule", (CommodityCalculationPeriodsSchedule) o.getPeriodsSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityCalculationPeriodsPointerModel", (CommodityCalculationPeriodsPointerModel) o.getCommodityCalculationPeriodsPointerModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("gasDeliveryPeriodsSequence", (GasDeliveryPeriodsSequence) o.getGasDeliveryPeriodsSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<GasDeliveryPeriods> validate(RosettaPath path, GasDeliveryPeriods o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GasDeliveryPeriods", ValidationType.CARDINALITY, "GasDeliveryPeriods", path, "", error);
		}
		return success("GasDeliveryPeriods", ValidationType.CARDINALITY, "GasDeliveryPeriods", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GasDeliveryPeriods o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GasDeliveryPeriods", ValidationType.CARDINALITY, "GasDeliveryPeriods", path, "", res.getError());
				}
				return success("GasDeliveryPeriods", ValidationType.CARDINALITY, "GasDeliveryPeriods", path, "");
			})
			.collect(toList());
	}

}
