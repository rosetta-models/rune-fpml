package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityBasket;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityBasketTypeFormatValidator implements Validator<CommodityBasket> {

	private List<ComparisonResult> getComparisonResults(CommodityBasket o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityBasket> validate(RosettaPath path, CommodityBasket o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityBasket", ValidationType.TYPE_FORMAT, "CommodityBasket", path, "", error);
		}
		return success("CommodityBasket", ValidationType.TYPE_FORMAT, "CommodityBasket", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasket o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBasket", ValidationType.TYPE_FORMAT, "CommodityBasket", path, "", res.getError());
				}
				return success("CommodityBasket", ValidationType.TYPE_FORMAT, "CommodityBasket", path, "");
			})
			.collect(toList());
	}

}
