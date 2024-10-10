package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BasketIdentifierModel;
import fpml.confirmation.CommodityBasket;
import fpml.confirmation.CommodityBasketModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityBasketValidator implements Validator<CommodityBasket> {

	private List<ComparisonResult> getComparisonResults(CommodityBasket o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("basketIdentifierModel", (BasketIdentifierModel) o.getBasketIdentifierModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityBasketModel", (CommodityBasketModel) o.getCommodityBasketModel() != null ? 1 : 0, 1, 1)
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
			return failure("CommodityBasket", ValidationType.CARDINALITY, "CommodityBasket", path, "", error);
		}
		return success("CommodityBasket", ValidationType.CARDINALITY, "CommodityBasket", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBasket o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBasket", ValidationType.CARDINALITY, "CommodityBasket", path, "", res.getError());
				}
				return success("CommodityBasket", ValidationType.CARDINALITY, "CommodityBasket", path, "");
			})
			.collect(toList());
	}

}
