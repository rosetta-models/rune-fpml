package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityBasketModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityBasketModelTypeFormatValidator implements Validator<CommodityBasketModel> {

	private List<ComparisonResult> getComparisonResults(CommodityBasketModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityBasketModel> validate(RosettaPath path, CommodityBasketModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityBasketModel", ValidationType.TYPE_FORMAT, "CommodityBasketModel", path, "", error);
		}
		return success("CommodityBasketModel", ValidationType.TYPE_FORMAT, "CommodityBasketModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasketModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBasketModel", ValidationType.TYPE_FORMAT, "CommodityBasketModel", path, "", res.getError());
				}
				return success("CommodityBasketModel", ValidationType.TYPE_FORMAT, "CommodityBasketModel", path, "");
			})
			.collect(toList());
	}

}
