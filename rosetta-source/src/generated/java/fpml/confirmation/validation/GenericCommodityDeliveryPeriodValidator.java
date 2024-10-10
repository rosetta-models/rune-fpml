package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DayOfWeekExtEnum;
import fpml.confirmation.GenericCommodityDeliveryPeriod;
import fpml.confirmation.GenericCommodityDeliveryPeriodSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GenericCommodityDeliveryPeriodValidator implements Validator<GenericCommodityDeliveryPeriod> {

	private List<ComparisonResult> getComparisonResults(GenericCommodityDeliveryPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("applicableDay", (List<DayOfWeekExtEnum>) o.getApplicableDay() == null ? 0 : ((List<DayOfWeekExtEnum>) o.getApplicableDay()).size(), 1, 7), 
				checkCardinality("genericCommodityDeliveryPeriodSequence", (GenericCommodityDeliveryPeriodSequence) o.getGenericCommodityDeliveryPeriodSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<GenericCommodityDeliveryPeriod> validate(RosettaPath path, GenericCommodityDeliveryPeriod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GenericCommodityDeliveryPeriod", ValidationType.CARDINALITY, "GenericCommodityDeliveryPeriod", path, "", error);
		}
		return success("GenericCommodityDeliveryPeriod", ValidationType.CARDINALITY, "GenericCommodityDeliveryPeriod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericCommodityDeliveryPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericCommodityDeliveryPeriod", ValidationType.CARDINALITY, "GenericCommodityDeliveryPeriod", path, "", res.getError());
				}
				return success("GenericCommodityDeliveryPeriod", ValidationType.CARDINALITY, "GenericCommodityDeliveryPeriod", path, "");
			})
			.collect(toList());
	}

}
