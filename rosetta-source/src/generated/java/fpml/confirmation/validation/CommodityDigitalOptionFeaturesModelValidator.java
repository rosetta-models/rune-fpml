package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CommodityAsianModel;
import fpml.confirmation.CommodityDigital;
import fpml.confirmation.CommodityDigitalOptionFeaturesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityDigitalOptionFeaturesModelValidator implements Validator<CommodityDigitalOptionFeaturesModel> {

	private List<ComparisonResult> getComparisonResults(CommodityDigitalOptionFeaturesModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminationDate", (AdjustableOrRelativeDate) o.getTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityAsianModel", (CommodityAsianModel) o.getCommodityAsianModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("digital", (CommodityDigital) o.getDigital() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommodityDigitalOptionFeaturesModel> validate(RosettaPath path, CommodityDigitalOptionFeaturesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityDigitalOptionFeaturesModel", ValidationType.CARDINALITY, "CommodityDigitalOptionFeaturesModel", path, "", error);
		}
		return success("CommodityDigitalOptionFeaturesModel", ValidationType.CARDINALITY, "CommodityDigitalOptionFeaturesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDigitalOptionFeaturesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityDigitalOptionFeaturesModel", ValidationType.CARDINALITY, "CommodityDigitalOptionFeaturesModel", path, "", res.getError());
				}
				return success("CommodityDigitalOptionFeaturesModel", ValidationType.CARDINALITY, "CommodityDigitalOptionFeaturesModel", path, "");
			})
			.collect(toList());
	}

}
