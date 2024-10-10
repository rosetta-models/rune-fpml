package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityTriggerSequence;
import fpml.confirmation.QuantityUnit;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityTriggerSequenceValidator implements Validator<CommodityTriggerSequence> {

	private List<ComparisonResult> getComparisonResults(CommodityTriggerSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("levelQuantity", (BigDecimal) o.getLevelQuantity() != null ? 1 : 0, 1, 1), 
				checkCardinality("levelUnit", (QuantityUnit) o.getLevelUnit() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommodityTriggerSequence> validate(RosettaPath path, CommodityTriggerSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityTriggerSequence", ValidationType.CARDINALITY, "CommodityTriggerSequence", path, "", error);
		}
		return success("CommodityTriggerSequence", ValidationType.CARDINALITY, "CommodityTriggerSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityTriggerSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityTriggerSequence", ValidationType.CARDINALITY, "CommodityTriggerSequence", path, "", res.getError());
				}
				return success("CommodityTriggerSequence", ValidationType.CARDINALITY, "CommodityTriggerSequence", path, "");
			})
			.collect(toList());
	}

}
