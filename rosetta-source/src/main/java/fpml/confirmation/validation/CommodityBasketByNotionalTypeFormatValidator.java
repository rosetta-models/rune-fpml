package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityBasketByNotional;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityBasketByNotionalTypeFormatValidator implements Validator<CommodityBasketByNotional> {

	private List<ComparisonResult> getComparisonResults(CommodityBasketByNotional o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityBasketByNotional> validate(RosettaPath path, CommodityBasketByNotional o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityBasketByNotional", ValidationType.TYPE_FORMAT, "CommodityBasketByNotional", path, "", error);
		}
		return success("CommodityBasketByNotional", ValidationType.TYPE_FORMAT, "CommodityBasketByNotional", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasketByNotional o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBasketByNotional", ValidationType.TYPE_FORMAT, "CommodityBasketByNotional", path, "", res.getError());
				}
				return success("CommodityBasketByNotional", ValidationType.TYPE_FORMAT, "CommodityBasketByNotional", path, "");
			})
			.collect(toList());
	}

}
