package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.CommodityProductModelSequence;
import fpml.confirmation.CommodityProductModelSequenceChoice;
import fpml.confirmation.Offset;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityProductModelSequenceValidator implements Validator<CommodityProductModelSequence> {

	private List<ComparisonResult> getComparisonResults(CommodityProductModelSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commodityProductModelSequenceChoice", (CommodityProductModelSequenceChoice) o.getCommodityProductModelSequenceChoice() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryDate", (AdjustableDate) o.getDeliveryDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryDateYearMonth", (Integer) o.getDeliveryDateYearMonth() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryDateRollConvention", (Offset) o.getDeliveryDateRollConvention() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryDateExpirationConvention", (Offset) o.getDeliveryDateExpirationConvention() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CommodityProductModelSequence> validate(RosettaPath path, CommodityProductModelSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityProductModelSequence", ValidationType.CARDINALITY, "CommodityProductModelSequence", path, "", error);
		}
		return success("CommodityProductModelSequence", ValidationType.CARDINALITY, "CommodityProductModelSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityProductModelSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityProductModelSequence", ValidationType.CARDINALITY, "CommodityProductModelSequence", path, "", res.getError());
				}
				return success("CommodityProductModelSequence", ValidationType.CARDINALITY, "CommodityProductModelSequence", path, "");
			})
			.collect(toList());
	}

}
