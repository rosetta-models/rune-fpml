package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GenericCommodityDeliveryPeriodSequence;
import fpml.confirmation.OffsetPrevailingTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GenericCommodityDeliveryPeriodSequenceValidator implements Validator<GenericCommodityDeliveryPeriodSequence> {

	private List<ComparisonResult> getComparisonResults(GenericCommodityDeliveryPeriodSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("startTime", (OffsetPrevailingTime) o.getStartTime() != null ? 1 : 0, 1, 1), 
				checkCardinality("endTime", (OffsetPrevailingTime) o.getEndTime() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<GenericCommodityDeliveryPeriodSequence> validate(RosettaPath path, GenericCommodityDeliveryPeriodSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GenericCommodityDeliveryPeriodSequence", ValidationType.CARDINALITY, "GenericCommodityDeliveryPeriodSequence", path, "", error);
		}
		return success("GenericCommodityDeliveryPeriodSequence", ValidationType.CARDINALITY, "GenericCommodityDeliveryPeriodSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericCommodityDeliveryPeriodSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericCommodityDeliveryPeriodSequence", ValidationType.CARDINALITY, "GenericCommodityDeliveryPeriodSequence", path, "", res.getError());
				}
				return success("GenericCommodityDeliveryPeriodSequence", ValidationType.CARDINALITY, "GenericCommodityDeliveryPeriodSequence", path, "");
			})
			.collect(toList());
	}

}
