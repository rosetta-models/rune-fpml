package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommoditySpread;
import fpml.confirmation.CommoditySpreadSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommoditySpreadScheduleValidator implements Validator<CommoditySpreadSchedule> {

	private List<ComparisonResult> getComparisonResults(CommoditySpreadSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("spreadStep", (List<? extends CommoditySpread>) o.getSpreadStep() == null ? 0 : ((List<? extends CommoditySpread>) o.getSpreadStep()).size(), 1, 0), 
				checkCardinality("commodityCalculationPeriodsPointerModel", (CommodityCalculationPeriodsPointerModel) o.getCommodityCalculationPeriodsPointerModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommoditySpreadSchedule> validate(RosettaPath path, CommoditySpreadSchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommoditySpreadSchedule", ValidationType.CARDINALITY, "CommoditySpreadSchedule", path, "", error);
		}
		return success("CommoditySpreadSchedule", ValidationType.CARDINALITY, "CommoditySpreadSchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommoditySpreadSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommoditySpreadSchedule", ValidationType.CARDINALITY, "CommoditySpreadSchedule", path, "", res.getError());
				}
				return success("CommoditySpreadSchedule", ValidationType.CARDINALITY, "CommoditySpreadSchedule", path, "");
			})
			.collect(toList());
	}

}
