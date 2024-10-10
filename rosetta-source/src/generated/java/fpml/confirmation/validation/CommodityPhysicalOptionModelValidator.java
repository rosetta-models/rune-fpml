package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityForward;
import fpml.confirmation.CommodityPhysicalExercise;
import fpml.confirmation.CommodityPhysicalOptionModel;
import fpml.confirmation.CommoditySwaptionUnderlying;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityPhysicalOptionModelValidator implements Validator<CommodityPhysicalOptionModel> {

	private List<ComparisonResult> getComparisonResults(CommodityPhysicalOptionModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commoditySwap", (CommoditySwaptionUnderlying) o.getCommoditySwap() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityForward", (CommodityForward) o.getCommodityForward() != null ? 1 : 0, 0, 1), 
				checkCardinality("physicalExercise", (CommodityPhysicalExercise) o.getPhysicalExercise() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommodityPhysicalOptionModel> validate(RosettaPath path, CommodityPhysicalOptionModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityPhysicalOptionModel", ValidationType.CARDINALITY, "CommodityPhysicalOptionModel", path, "", error);
		}
		return success("CommodityPhysicalOptionModel", ValidationType.CARDINALITY, "CommodityPhysicalOptionModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPhysicalOptionModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPhysicalOptionModel", ValidationType.CARDINALITY, "CommodityPhysicalOptionModel", path, "", res.getError());
				}
				return success("CommodityPhysicalOptionModel", ValidationType.CARDINALITY, "CommodityPhysicalOptionModel", path, "");
			})
			.collect(toList());
	}

}
