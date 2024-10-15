package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityReturnCalculation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityReturnCalculationTypeFormatValidator implements Validator<CommodityReturnCalculation> {

	private List<ComparisonResult> getComparisonResults(CommodityReturnCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityReturnCalculation> validate(RosettaPath path, CommodityReturnCalculation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityReturnCalculation", ValidationType.TYPE_FORMAT, "CommodityReturnCalculation", path, "", error);
		}
		return success("CommodityReturnCalculation", ValidationType.TYPE_FORMAT, "CommodityReturnCalculation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityReturnCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityReturnCalculation", ValidationType.TYPE_FORMAT, "CommodityReturnCalculation", path, "", res.getError());
				}
				return success("CommodityReturnCalculation", ValidationType.TYPE_FORMAT, "CommodityReturnCalculation", path, "");
			})
			.collect(toList());
	}

}
