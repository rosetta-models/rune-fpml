package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityBasketUnderlyingByNotional;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityBasketUnderlyingByNotionalTypeFormatValidator implements Validator<CommodityBasketUnderlyingByNotional> {

	private List<ComparisonResult> getComparisonResults(CommodityBasketUnderlyingByNotional o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityBasketUnderlyingByNotional> validate(RosettaPath path, CommodityBasketUnderlyingByNotional o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityBasketUnderlyingByNotional", ValidationType.TYPE_FORMAT, "CommodityBasketUnderlyingByNotional", path, "", error);
		}
		return success("CommodityBasketUnderlyingByNotional", ValidationType.TYPE_FORMAT, "CommodityBasketUnderlyingByNotional", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasketUnderlyingByNotional o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBasketUnderlyingByNotional", ValidationType.TYPE_FORMAT, "CommodityBasketUnderlyingByNotional", path, "", res.getError());
				}
				return success("CommodityBasketUnderlyingByNotional", ValidationType.TYPE_FORMAT, "CommodityBasketUnderlyingByNotional", path, "");
			})
			.collect(toList());
	}

}
