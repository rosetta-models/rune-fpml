package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CommodityBarrier;
import fpml.confirmation.CommodityOptionFeaturesModel;
import fpml.confirmation.CommodityOptionFeaturesModelSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityOptionFeaturesModelValidator implements Validator<CommodityOptionFeaturesModel> {

	private List<ComparisonResult> getComparisonResults(CommodityOptionFeaturesModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("terminationDate", (AdjustableOrRelativeDate) o.getTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityOptionFeaturesModelSequence", (CommodityOptionFeaturesModelSequence) o.getCommodityOptionFeaturesModelSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("barrier", (CommodityBarrier) o.getBarrier() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityOptionFeaturesModel> validate(RosettaPath path, CommodityOptionFeaturesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityOptionFeaturesModel", ValidationType.CARDINALITY, "CommodityOptionFeaturesModel", path, "", error);
		}
		return success("CommodityOptionFeaturesModel", ValidationType.CARDINALITY, "CommodityOptionFeaturesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityOptionFeaturesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityOptionFeaturesModel", ValidationType.CARDINALITY, "CommodityOptionFeaturesModel", path, "", res.getError());
				}
				return success("CommodityOptionFeaturesModel", ValidationType.CARDINALITY, "CommodityOptionFeaturesModel", path, "");
			})
			.collect(toList());
	}

}
