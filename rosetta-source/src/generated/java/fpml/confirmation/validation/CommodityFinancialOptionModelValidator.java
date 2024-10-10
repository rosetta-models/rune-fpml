package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityExercise;
import fpml.confirmation.CommodityFinancialOptionModel;
import fpml.confirmation.CommodityFloatingStrikePriceModel;
import fpml.confirmation.CommodityNotionalQuantityModel;
import fpml.confirmation.CommodityOptionFeaturesModel;
import fpml.confirmation.CommodityStrikePriceModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityFinancialOptionModelValidator implements Validator<CommodityFinancialOptionModel> {

	private List<ComparisonResult> getComparisonResults(CommodityFinancialOptionModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commodity", (Commodity) o.getCommodity() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityOptionFeaturesModel", (CommodityOptionFeaturesModel) o.getCommodityOptionFeaturesModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityNotionalQuantityModel", (CommodityNotionalQuantityModel) o.getCommodityNotionalQuantityModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("exercise", (CommodityExercise) o.getExercise() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityStrikePriceModel", (CommodityStrikePriceModel) o.getCommodityStrikePriceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityFloatingStrikePriceModel", (CommodityFloatingStrikePriceModel) o.getCommodityFloatingStrikePriceModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityFinancialOptionModel> validate(RosettaPath path, CommodityFinancialOptionModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityFinancialOptionModel", ValidationType.CARDINALITY, "CommodityFinancialOptionModel", path, "", error);
		}
		return success("CommodityFinancialOptionModel", ValidationType.CARDINALITY, "CommodityFinancialOptionModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityFinancialOptionModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityFinancialOptionModel", ValidationType.CARDINALITY, "CommodityFinancialOptionModel", path, "", res.getError());
				}
				return success("CommodityFinancialOptionModel", ValidationType.CARDINALITY, "CommodityFinancialOptionModel", path, "");
			})
			.collect(toList());
	}

}
