package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityDeliveryPointsModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityDeliveryPointsModelTypeFormatValidator implements Validator<CommodityDeliveryPointsModel> {

	private List<ComparisonResult> getComparisonResults(CommodityDeliveryPointsModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityDeliveryPointsModel> validate(RosettaPath path, CommodityDeliveryPointsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityDeliveryPointsModel", ValidationType.TYPE_FORMAT, "CommodityDeliveryPointsModel", path, "", error);
		}
		return success("CommodityDeliveryPointsModel", ValidationType.TYPE_FORMAT, "CommodityDeliveryPointsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDeliveryPointsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityDeliveryPointsModel", ValidationType.TYPE_FORMAT, "CommodityDeliveryPointsModel", path, "", res.getError());
				}
				return success("CommodityDeliveryPointsModel", ValidationType.TYPE_FORMAT, "CommodityDeliveryPointsModel", path, "");
			})
			.collect(toList());
	}

}
