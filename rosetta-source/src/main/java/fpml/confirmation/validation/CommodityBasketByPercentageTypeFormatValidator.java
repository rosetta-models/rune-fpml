package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityBasketByPercentage;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityBasketByPercentageTypeFormatValidator implements Validator<CommodityBasketByPercentage> {

	private List<ComparisonResult> getComparisonResults(CommodityBasketByPercentage o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityBasketByPercentage> validate(RosettaPath path, CommodityBasketByPercentage o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityBasketByPercentage", ValidationType.TYPE_FORMAT, "CommodityBasketByPercentage", path, "", error);
		}
		return success("CommodityBasketByPercentage", ValidationType.TYPE_FORMAT, "CommodityBasketByPercentage", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasketByPercentage o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBasketByPercentage", ValidationType.TYPE_FORMAT, "CommodityBasketByPercentage", path, "", res.getError());
				}
				return success("CommodityBasketByPercentage", ValidationType.TYPE_FORMAT, "CommodityBasketByPercentage", path, "");
			})
			.collect(toList());
	}

}
