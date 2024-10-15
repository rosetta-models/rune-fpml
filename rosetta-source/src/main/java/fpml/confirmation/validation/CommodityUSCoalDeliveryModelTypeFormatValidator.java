package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityUSCoalDeliveryModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityUSCoalDeliveryModelTypeFormatValidator implements Validator<CommodityUSCoalDeliveryModel> {

	private List<ComparisonResult> getComparisonResults(CommodityUSCoalDeliveryModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityUSCoalDeliveryModel> validate(RosettaPath path, CommodityUSCoalDeliveryModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityUSCoalDeliveryModel", ValidationType.TYPE_FORMAT, "CommodityUSCoalDeliveryModel", path, "", error);
		}
		return success("CommodityUSCoalDeliveryModel", ValidationType.TYPE_FORMAT, "CommodityUSCoalDeliveryModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityUSCoalDeliveryModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityUSCoalDeliveryModel", ValidationType.TYPE_FORMAT, "CommodityUSCoalDeliveryModel", path, "", res.getError());
				}
				return success("CommodityUSCoalDeliveryModel", ValidationType.TYPE_FORMAT, "CommodityUSCoalDeliveryModel", path, "");
			})
			.collect(toList());
	}

}
