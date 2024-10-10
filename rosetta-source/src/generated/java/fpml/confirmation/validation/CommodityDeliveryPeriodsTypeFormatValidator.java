package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityDeliveryPeriods;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityDeliveryPeriodsTypeFormatValidator implements Validator<CommodityDeliveryPeriods> {

	private List<ComparisonResult> getComparisonResults(CommodityDeliveryPeriods o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityDeliveryPeriods> validate(RosettaPath path, CommodityDeliveryPeriods o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityDeliveryPeriods", ValidationType.TYPE_FORMAT, "CommodityDeliveryPeriods", path, "", error);
		}
		return success("CommodityDeliveryPeriods", ValidationType.TYPE_FORMAT, "CommodityDeliveryPeriods", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityDeliveryPeriods o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityDeliveryPeriods", ValidationType.TYPE_FORMAT, "CommodityDeliveryPeriods", path, "", res.getError());
				}
				return success("CommodityDeliveryPeriods", ValidationType.TYPE_FORMAT, "CommodityDeliveryPeriods", path, "");
			})
			.collect(toList());
	}

}
