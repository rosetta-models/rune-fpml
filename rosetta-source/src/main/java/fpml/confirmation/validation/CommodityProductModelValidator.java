package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityProductModel;
import fpml.confirmation.CommodityProductModelSequence;
import fpml.confirmation.CommodityReferencePriceFrameworkModel;
import fpml.confirmation.SpecifiedPriceEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityProductModelValidator implements Validator<CommodityProductModel> {

	private List<ComparisonResult> getComparisonResults(CommodityProductModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commodityReferencePriceFrameworkModel", (CommodityReferencePriceFrameworkModel) o.getCommodityReferencePriceFrameworkModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("specifiedPrice", (SpecifiedPriceEnum) o.getSpecifiedPrice() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityProductModelSequence", (CommodityProductModelSequence) o.getCommodityProductModelSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("multiplier", (BigDecimal) o.getMultiplier() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityProductModel> validate(RosettaPath path, CommodityProductModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityProductModel", ValidationType.CARDINALITY, "CommodityProductModel", path, "", error);
		}
		return success("CommodityProductModel", ValidationType.CARDINALITY, "CommodityProductModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityProductModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityProductModel", ValidationType.CARDINALITY, "CommodityProductModel", path, "", res.getError());
				}
				return success("CommodityProductModel", ValidationType.CARDINALITY, "CommodityProductModel", path, "");
			})
			.collect(toList());
	}

}
