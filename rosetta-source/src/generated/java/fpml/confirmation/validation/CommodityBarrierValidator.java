package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityBarrier;
import fpml.confirmation.CommodityKnockEnum;
import fpml.confirmation.CommodityTrigger;
import fpml.confirmation.PositiveMoney;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommodityBarrierValidator implements Validator<CommodityBarrier> {

	private List<ComparisonResult> getComparisonResults(CommodityBarrier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("knock", (CommodityKnockEnum) o.getKnock() != null ? 1 : 0, 1, 1), 
				checkCardinality("featurePaymentAmount", (PositiveMoney) o.getFeaturePaymentAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("trigger", (CommodityTrigger) o.getTrigger() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommodityBarrier> validate(RosettaPath path, CommodityBarrier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommodityBarrier", ValidationType.CARDINALITY, "CommodityBarrier", path, "", error);
		}
		return success("CommodityBarrier", ValidationType.CARDINALITY, "CommodityBarrier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityBarrier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityBarrier", ValidationType.CARDINALITY, "CommodityBarrier", path, "", res.getError());
				}
				return success("CommodityBarrier", ValidationType.CARDINALITY, "CommodityBarrier", path, "");
			})
			.collect(toList());
	}

}
