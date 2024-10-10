package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityBasket;
import fpml.confirmation.CommodityUnderlyerChoiceModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityUnderlyerChoiceModelValidator implements Validator<CommodityUnderlyerChoiceModel> {

	private List<ComparisonResult> getComparisonResults(CommodityUnderlyerChoiceModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commodity", (Commodity) o.getCommodity() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityBasket", (CommodityBasket) o.getCommodityBasket() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityUnderlyerChoiceModel> validate(RosettaPath path, CommodityUnderlyerChoiceModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityUnderlyerChoiceModel", ValidationType.CARDINALITY, "CommodityUnderlyerChoiceModel", path, "", error);
		}
		return success("CommodityUnderlyerChoiceModel", ValidationType.CARDINALITY, "CommodityUnderlyerChoiceModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityUnderlyerChoiceModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityUnderlyerChoiceModel", ValidationType.CARDINALITY, "CommodityUnderlyerChoiceModel", path, "", res.getError());
				}
				return success("CommodityUnderlyerChoiceModel", ValidationType.CARDINALITY, "CommodityUnderlyerChoiceModel", path, "");
			})
			.collect(toList());
	}

}
