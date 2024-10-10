package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommodityStrikeSchedule;
import fpml.confirmation.NonNegativeMoney;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityStrikeScheduleValidator implements Validator<CommodityStrikeSchedule> {

	private List<ComparisonResult> getComparisonResults(CommodityStrikeSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("strikePricePerUnitStep", (List<? extends NonNegativeMoney>) o.getStrikePricePerUnitStep() == null ? 0 : ((List<? extends NonNegativeMoney>) o.getStrikePricePerUnitStep()).size(), 1, 0), 
				checkCardinality("commodityCalculationPeriodsPointerModel", (CommodityCalculationPeriodsPointerModel) o.getCommodityCalculationPeriodsPointerModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommodityStrikeSchedule> validate(RosettaPath path, CommodityStrikeSchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityStrikeSchedule", ValidationType.CARDINALITY, "CommodityStrikeSchedule", path, "", error);
		}
		return success("CommodityStrikeSchedule", ValidationType.CARDINALITY, "CommodityStrikeSchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityStrikeSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityStrikeSchedule", ValidationType.CARDINALITY, "CommodityStrikeSchedule", path, "", res.getError());
				}
				return success("CommodityStrikeSchedule", ValidationType.CARDINALITY, "CommodityStrikeSchedule", path, "");
			})
			.collect(toList());
	}

}
