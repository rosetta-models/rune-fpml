package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CalculationPeriodsReference;
import fpml.confirmation.CalculationPeriodsScheduleReference;
import fpml.confirmation.CommodityDeliveryPeriodsPointerModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityDeliveryPeriodsPointerModelValidator implements Validator<CommodityDeliveryPeriodsPointerModel> {

	private List<ComparisonResult> getComparisonResults(CommodityDeliveryPeriodsPointerModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("deliveryPeriodsReference", (CalculationPeriodsReference) o.getDeliveryPeriodsReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryPeriodsScheduleReference", (CalculationPeriodsScheduleReference) o.getDeliveryPeriodsScheduleReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityDeliveryPeriodsPointerModel> validate(RosettaPath path, CommodityDeliveryPeriodsPointerModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityDeliveryPeriodsPointerModel", ValidationType.CARDINALITY, "CommodityDeliveryPeriodsPointerModel", path, "", error);
		}
		return success("CommodityDeliveryPeriodsPointerModel", ValidationType.CARDINALITY, "CommodityDeliveryPeriodsPointerModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDeliveryPeriodsPointerModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityDeliveryPeriodsPointerModel", ValidationType.CARDINALITY, "CommodityDeliveryPeriodsPointerModel", path, "", res.getError());
				}
				return success("CommodityDeliveryPeriodsPointerModel", ValidationType.CARDINALITY, "CommodityDeliveryPeriodsPointerModel", path, "");
			})
			.collect(toList());
	}

}
