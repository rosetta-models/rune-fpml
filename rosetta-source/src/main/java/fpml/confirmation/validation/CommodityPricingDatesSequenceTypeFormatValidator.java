package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityPricingDatesSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityPricingDatesSequenceTypeFormatValidator implements Validator<CommodityPricingDatesSequence> {

	private List<ComparisonResult> getComparisonResults(CommodityPricingDatesSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CommodityPricingDatesSequence> validate(RosettaPath path, CommodityPricingDatesSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityPricingDatesSequence", ValidationType.TYPE_FORMAT, "CommodityPricingDatesSequence", path, "", error);
		}
		return success("CommodityPricingDatesSequence", ValidationType.TYPE_FORMAT, "CommodityPricingDatesSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPricingDatesSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPricingDatesSequence", ValidationType.TYPE_FORMAT, "CommodityPricingDatesSequence", path, "", res.getError());
				}
				return success("CommodityPricingDatesSequence", ValidationType.TYPE_FORMAT, "CommodityPricingDatesSequence", path, "");
			})
			.collect(toList());
	}

}
