package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityPricingDates;
import fpml.confirmation.CommodityValuationDates;
import fpml.confirmation.CommodityVarianceCalculation;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityVarianceCalculationValidator implements Validator<CommodityVarianceCalculation> {

	private List<ComparisonResult> getComparisonResults(CommodityVarianceCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("pricingDates", (CommodityPricingDates) o.getPricingDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationDates", (CommodityValuationDates) o.getValuationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("annualizationFactor", (BigDecimal) o.getAnnualizationFactor() != null ? 1 : 0, 1, 1), 
				checkCardinality("nAdjustment", (Boolean) o.getNAdjustment() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommodityVarianceCalculation> validate(RosettaPath path, CommodityVarianceCalculation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityVarianceCalculation", ValidationType.CARDINALITY, "CommodityVarianceCalculation", path, "", error);
		}
		return success("CommodityVarianceCalculation", ValidationType.CARDINALITY, "CommodityVarianceCalculation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityVarianceCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityVarianceCalculation", ValidationType.CARDINALITY, "CommodityVarianceCalculation", path, "", res.getError());
				}
				return success("CommodityVarianceCalculation", ValidationType.CARDINALITY, "CommodityVarianceCalculation", path, "");
			})
			.collect(toList());
	}

}
