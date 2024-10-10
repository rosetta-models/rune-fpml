package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CalculationPeriodsDatesReference;
import fpml.confirmation.CalculationPeriodsReference;
import fpml.confirmation.CalculationPeriodsScheduleReference;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityCalculationPeriodsPointerModelValidator implements Validator<CommodityCalculationPeriodsPointerModel> {

	private List<ComparisonResult> getComparisonResults(CommodityCalculationPeriodsPointerModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationPeriodsReference", (CalculationPeriodsReference) o.getCalculationPeriodsReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsScheduleReference", (CalculationPeriodsScheduleReference) o.getCalculationPeriodsScheduleReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsDatesReference", (CalculationPeriodsDatesReference) o.getCalculationPeriodsDatesReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityCalculationPeriodsPointerModel> validate(RosettaPath path, CommodityCalculationPeriodsPointerModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityCalculationPeriodsPointerModel", ValidationType.CARDINALITY, "CommodityCalculationPeriodsPointerModel", path, "", error);
		}
		return success("CommodityCalculationPeriodsPointerModel", ValidationType.CARDINALITY, "CommodityCalculationPeriodsPointerModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityCalculationPeriodsPointerModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityCalculationPeriodsPointerModel", ValidationType.CARDINALITY, "CommodityCalculationPeriodsPointerModel", path, "", res.getError());
				}
				return success("CommodityCalculationPeriodsPointerModel", ValidationType.CARDINALITY, "CommodityCalculationPeriodsPointerModel", path, "");
			})
			.collect(toList());
	}

}
