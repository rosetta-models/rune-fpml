package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityTrigger;
import fpml.confirmation.CommodityTriggerSequence;
import fpml.confirmation.FixedPrice;
import fpml.confirmation.TriggerTypeEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityTriggerValidator implements Validator<CommodityTrigger> {

	private List<ComparisonResult> getComparisonResults(CommodityTrigger o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commodityTriggerSequence", (CommodityTriggerSequence) o.getCommodityTriggerSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("levelPercentage", (BigDecimal) o.getLevelPercentage() != null ? 1 : 0, 0, 1), 
				checkCardinality("levelPrice", (FixedPrice) o.getLevelPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerType", (TriggerTypeEnum) o.getTriggerType() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommodityTrigger> validate(RosettaPath path, CommodityTrigger o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityTrigger", ValidationType.CARDINALITY, "CommodityTrigger", path, "", error);
		}
		return success("CommodityTrigger", ValidationType.CARDINALITY, "CommodityTrigger", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityTrigger o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityTrigger", ValidationType.CARDINALITY, "CommodityTrigger", path, "", res.getError());
				}
				return success("CommodityTrigger", ValidationType.CARDINALITY, "CommodityTrigger", path, "");
			})
			.collect(toList());
	}

}
