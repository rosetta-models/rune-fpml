package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityTrigger;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityTriggerTypeFormatValidator implements Validator<CommodityTrigger> {

	private List<ComparisonResult> getComparisonResults(CommodityTrigger o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityTrigger> validate(RosettaPath path, CommodityTrigger o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityTrigger", ValidationType.TYPE_FORMAT, "CommodityTrigger", path, "", error);
		}
		return success("CommodityTrigger", ValidationType.TYPE_FORMAT, "CommodityTrigger", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityTrigger o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityTrigger", ValidationType.TYPE_FORMAT, "CommodityTrigger", path, "", res.getError());
				}
				return success("CommodityTrigger", ValidationType.TYPE_FORMAT, "CommodityTrigger", path, "");
			})
			.collect(toList());
	}

}
