package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityPricingDatesSequence;
import fpml.confirmation.CommodityPricingDatesSequenceSequence;
import fpml.confirmation.Lag;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityPricingDatesSequenceValidator implements Validator<CommodityPricingDatesSequence> {

	private List<ComparisonResult> getComparisonResults(CommodityPricingDatesSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("lag", (Lag) o.getLag() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityPricingDatesSequenceSequence", (CommodityPricingDatesSequenceSequence) o.getCommodityPricingDatesSequenceSequence() != null ? 1 : 0, 0, 1)
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
			return failure("CommodityPricingDatesSequence", ValidationType.CARDINALITY, "CommodityPricingDatesSequence", path, "", error);
		}
		return success("CommodityPricingDatesSequence", ValidationType.CARDINALITY, "CommodityPricingDatesSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityPricingDatesSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityPricingDatesSequence", ValidationType.CARDINALITY, "CommodityPricingDatesSequence", path, "", res.getError());
				}
				return success("CommodityPricingDatesSequence", ValidationType.CARDINALITY, "CommodityPricingDatesSequence", path, "");
			})
			.collect(toList());
	}

}
