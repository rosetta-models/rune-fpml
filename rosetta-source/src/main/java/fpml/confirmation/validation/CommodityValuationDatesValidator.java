package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommodityValuationDates;
import fpml.confirmation.CommodityValuationDatesSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityValuationDatesValidator implements Validator<CommodityValuationDates> {

	private List<ComparisonResult> getComparisonResults(CommodityValuationDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commodityCalculationPeriodsPointerModel", (CommodityCalculationPeriodsPointerModel) o.getCommodityCalculationPeriodsPointerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityValuationDatesSequence", (CommodityValuationDatesSequence) o.getCommodityValuationDatesSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityValuationDates> validate(RosettaPath path, CommodityValuationDates o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityValuationDates", ValidationType.CARDINALITY, "CommodityValuationDates", path, "", error);
		}
		return success("CommodityValuationDates", ValidationType.CARDINALITY, "CommodityValuationDates", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityValuationDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityValuationDates", ValidationType.CARDINALITY, "CommodityValuationDates", path, "", res.getError());
				}
				return success("CommodityValuationDates", ValidationType.CARDINALITY, "CommodityValuationDates", path, "");
			})
			.collect(toList());
	}

}
