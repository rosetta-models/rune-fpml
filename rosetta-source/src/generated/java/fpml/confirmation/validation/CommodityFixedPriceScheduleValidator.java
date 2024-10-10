package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommodityFixedPriceSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityFixedPriceScheduleValidator implements Validator<CommodityFixedPriceSchedule> {

	private List<ComparisonResult> getComparisonResults(CommodityFixedPriceSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commodityCalculationPeriodsPointerModel", (CommodityCalculationPeriodsPointerModel) o.getCommodityCalculationPeriodsPointerModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommodityFixedPriceSchedule> validate(RosettaPath path, CommodityFixedPriceSchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityFixedPriceSchedule", ValidationType.CARDINALITY, "CommodityFixedPriceSchedule", path, "", error);
		}
		return success("CommodityFixedPriceSchedule", ValidationType.CARDINALITY, "CommodityFixedPriceSchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFixedPriceSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFixedPriceSchedule", ValidationType.CARDINALITY, "CommodityFixedPriceSchedule", path, "", res.getError());
				}
				return success("CommodityFixedPriceSchedule", ValidationType.CARDINALITY, "CommodityFixedPriceSchedule", path, "");
			})
			.collect(toList());
	}

}
