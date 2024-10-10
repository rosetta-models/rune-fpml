package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommoditySwapDetailsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommoditySwapDetailsModelTypeFormatValidator implements Validator<CommoditySwapDetailsModel> {

	private List<ComparisonResult> getComparisonResults(CommoditySwapDetailsModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommoditySwapDetailsModel> validate(RosettaPath path, CommoditySwapDetailsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommoditySwapDetailsModel", ValidationType.TYPE_FORMAT, "CommoditySwapDetailsModel", path, "", error);
		}
		return success("CommoditySwapDetailsModel", ValidationType.TYPE_FORMAT, "CommoditySwapDetailsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommoditySwapDetailsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommoditySwapDetailsModel", ValidationType.TYPE_FORMAT, "CommoditySwapDetailsModel", path, "", res.getError());
				}
				return success("CommoditySwapDetailsModel", ValidationType.TYPE_FORMAT, "CommoditySwapDetailsModel", path, "");
			})
			.collect(toList());
	}

}
