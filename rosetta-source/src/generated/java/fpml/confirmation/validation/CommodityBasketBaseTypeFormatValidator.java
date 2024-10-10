package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityBasketBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityBasketBaseTypeFormatValidator implements Validator<CommodityBasketBase> {

	private List<ComparisonResult> getComparisonResults(CommodityBasketBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityBasketBase> validate(RosettaPath path, CommodityBasketBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityBasketBase", ValidationType.TYPE_FORMAT, "CommodityBasketBase", path, "", error);
		}
		return success("CommodityBasketBase", ValidationType.TYPE_FORMAT, "CommodityBasketBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasketBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBasketBase", ValidationType.TYPE_FORMAT, "CommodityBasketBase", path, "", res.getError());
				}
				return success("CommodityBasketBase", ValidationType.TYPE_FORMAT, "CommodityBasketBase", path, "");
			})
			.collect(toList());
	}

}
