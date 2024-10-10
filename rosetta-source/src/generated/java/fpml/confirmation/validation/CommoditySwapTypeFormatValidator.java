package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommoditySwap;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommoditySwapTypeFormatValidator implements Validator<CommoditySwap> {

	private List<ComparisonResult> getComparisonResults(CommoditySwap o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommoditySwap> validate(RosettaPath path, CommoditySwap o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommoditySwap", ValidationType.TYPE_FORMAT, "CommoditySwap", path, "", error);
		}
		return success("CommoditySwap", ValidationType.TYPE_FORMAT, "CommoditySwap", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommoditySwap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommoditySwap", ValidationType.TYPE_FORMAT, "CommoditySwap", path, "", res.getError());
				}
				return success("CommoditySwap", ValidationType.TYPE_FORMAT, "CommoditySwap", path, "");
			})
			.collect(toList());
	}

}
