package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CommodityBasketOptionFeaturesModel;
import fpml.confirmation.CommodityCalculationPeriodsSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityBasketOptionFeaturesModelValidator implements Validator<CommodityBasketOptionFeaturesModel> {

	private List<ComparisonResult> getComparisonResults(CommodityBasketOptionFeaturesModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("terminationDate", (AdjustableOrRelativeDate) o.getTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsSchedule", (CommodityCalculationPeriodsSchedule) o.getCalculationPeriodsSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriods", (AdjustableDates) o.getCalculationPeriods() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityBasketOptionFeaturesModel> validate(RosettaPath path, CommodityBasketOptionFeaturesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityBasketOptionFeaturesModel", ValidationType.CARDINALITY, "CommodityBasketOptionFeaturesModel", path, "", error);
		}
		return success("CommodityBasketOptionFeaturesModel", ValidationType.CARDINALITY, "CommodityBasketOptionFeaturesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasketOptionFeaturesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBasketOptionFeaturesModel", ValidationType.CARDINALITY, "CommodityBasketOptionFeaturesModel", path, "", res.getError());
				}
				return success("CommodityBasketOptionFeaturesModel", ValidationType.CARDINALITY, "CommodityBasketOptionFeaturesModel", path, "");
			})
			.collect(toList());
	}

}
