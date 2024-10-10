package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityCalculationPeriodsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityCalculationPeriodsModelTypeFormatValidator implements Validator<CommodityCalculationPeriodsModel> {

	private List<ComparisonResult> getComparisonResults(CommodityCalculationPeriodsModel o) {
		return Lists.<ComparisonResult>newArrayList(
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
			return failure("CommodityCalculationPeriodsModel", ValidationType.TYPE_FORMAT, "CommodityCalculationPeriodsModel", path, "", error);
		}
		return success("CommodityCalculationPeriodsModel", ValidationType.TYPE_FORMAT, "CommodityCalculationPeriodsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityCalculationPeriodsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityCalculationPeriodsModel", ValidationType.TYPE_FORMAT, "CommodityCalculationPeriodsModel", path, "", res.getError());
				}
				return success("CommodityCalculationPeriodsModel", ValidationType.TYPE_FORMAT, "CommodityCalculationPeriodsModel", path, "");
			})
			.collect(toList());
	}

}
