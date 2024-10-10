package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.CommodityCalculationPeriodsModel;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommodityCalculationPeriodsSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityCalculationPeriodsModelValidator implements Validator<CommodityCalculationPeriodsModel> {

	private List<ComparisonResult> getComparisonResults(CommodityCalculationPeriodsModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationDates", (AdjustableDates) o.getCalculationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriods", (AdjustableDates) o.getCalculationPeriods() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsSchedule", (CommodityCalculationPeriodsSchedule) o.getCalculationPeriodsSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityCalculationPeriodsPointerModel", (CommodityCalculationPeriodsPointerModel) o.getCommodityCalculationPeriodsPointerModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityCalculationPeriodsModel> validate(RosettaPath path, CommodityCalculationPeriodsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityCalculationPeriodsModel", ValidationType.CARDINALITY, "CommodityCalculationPeriodsModel", path, "", error);
		}
		return success("CommodityCalculationPeriodsModel", ValidationType.CARDINALITY, "CommodityCalculationPeriodsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityCalculationPeriodsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityCalculationPeriodsModel", ValidationType.CARDINALITY, "CommodityCalculationPeriodsModel", path, "", res.getError());
				}
				return success("CommodityCalculationPeriodsModel", ValidationType.CARDINALITY, "CommodityCalculationPeriodsModel", path, "");
			})
			.collect(toList());
	}

}
