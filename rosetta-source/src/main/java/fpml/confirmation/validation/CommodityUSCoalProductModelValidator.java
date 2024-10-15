package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CoalQualityAdjustments;
import fpml.confirmation.CommodityUSCoalProductModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityUSCoalProductModelValidator implements Validator<CommodityUSCoalProductModel> {

	private List<ComparisonResult> getComparisonResults(CommodityUSCoalProductModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("btuQualityAdjustment", (CoalQualityAdjustments) o.getBtuQualityAdjustment() != null ? 1 : 0, 1, 1), 
				checkCardinality("so2QualityAdjustment", (CoalQualityAdjustments) o.getSo2QualityAdjustment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityUSCoalProductModel> validate(RosettaPath path, CommodityUSCoalProductModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityUSCoalProductModel", ValidationType.CARDINALITY, "CommodityUSCoalProductModel", path, "", error);
		}
		return success("CommodityUSCoalProductModel", ValidationType.CARDINALITY, "CommodityUSCoalProductModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityUSCoalProductModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityUSCoalProductModel", ValidationType.CARDINALITY, "CommodityUSCoalProductModel", path, "", res.getError());
				}
				return success("CommodityUSCoalProductModel", ValidationType.CARDINALITY, "CommodityUSCoalProductModel", path, "");
			})
			.collect(toList());
	}

}
