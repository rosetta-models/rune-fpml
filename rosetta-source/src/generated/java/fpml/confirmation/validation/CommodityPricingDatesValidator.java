package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommodityPricingDates;
import fpml.confirmation.CommodityPricingDatesSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityPricingDatesValidator implements Validator<CommodityPricingDates> {

	private List<ComparisonResult> getComparisonResults(CommodityPricingDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commodityCalculationPeriodsPointerModel", (CommodityCalculationPeriodsPointerModel) o.getCommodityCalculationPeriodsPointerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityPricingDatesSequence", (CommodityPricingDatesSequence) o.getCommodityPricingDatesSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityPricingDates> validate(RosettaPath path, CommodityPricingDates o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityPricingDates", ValidationType.CARDINALITY, "CommodityPricingDates", path, "", error);
		}
		return success("CommodityPricingDates", ValidationType.CARDINALITY, "CommodityPricingDates", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPricingDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPricingDates", ValidationType.CARDINALITY, "CommodityPricingDates", path, "", res.getError());
				}
				return success("CommodityPricingDates", ValidationType.CARDINALITY, "CommodityPricingDates", path, "");
			})
			.collect(toList());
	}

}
