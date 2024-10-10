package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityPricingDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityPricingDatesTypeFormatValidator implements Validator<CommodityPricingDates> {

	private List<ComparisonResult> getComparisonResults(CommodityPricingDates o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityPricingDates> validate(RosettaPath path, CommodityPricingDates o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityPricingDates", ValidationType.TYPE_FORMAT, "CommodityPricingDates", path, "", error);
		}
		return success("CommodityPricingDates", ValidationType.TYPE_FORMAT, "CommodityPricingDates", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPricingDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPricingDates", ValidationType.TYPE_FORMAT, "CommodityPricingDates", path, "", res.getError());
				}
				return success("CommodityPricingDates", ValidationType.TYPE_FORMAT, "CommodityPricingDates", path, "");
			})
			.collect(toList());
	}

}
