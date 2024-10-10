package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityOptionFeaturesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityOptionFeaturesModelTypeFormatValidator implements Validator<CommodityOptionFeaturesModel> {

	private List<ComparisonResult> getComparisonResults(CommodityOptionFeaturesModel o) {
		return Lists.<ComparisonResult>newArrayList(
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
			return failure("CommodityOptionFeaturesModel", ValidationType.TYPE_FORMAT, "CommodityOptionFeaturesModel", path, "", error);
		}
		return success("CommodityOptionFeaturesModel", ValidationType.TYPE_FORMAT, "CommodityOptionFeaturesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityOptionFeaturesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityOptionFeaturesModel", ValidationType.TYPE_FORMAT, "CommodityOptionFeaturesModel", path, "", res.getError());
				}
				return success("CommodityOptionFeaturesModel", ValidationType.TYPE_FORMAT, "CommodityOptionFeaturesModel", path, "");
			})
			.collect(toList());
	}

}
