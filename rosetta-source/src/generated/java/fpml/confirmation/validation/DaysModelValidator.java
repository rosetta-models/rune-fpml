package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessDayConventionEnum;
import fpml.confirmation.CommodityDayTypeEnum;
import fpml.confirmation.DaysModel;
import fpml.confirmation.DaysModelSequence0;
import fpml.confirmation.DaysModelSequence1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DaysModelValidator implements Validator<DaysModel> {

	private List<ComparisonResult> getComparisonResults(DaysModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dayType", (CommodityDayTypeEnum) o.getDayType() != null ? 1 : 0, 1, 1), 
				checkCardinality("daysModelSequence0", (DaysModelSequence0) o.getDaysModelSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("daysModelSequence1", (DaysModelSequence1) o.getDaysModelSequence1() != null ? 1 : 0, 0, 1), 
				checkCardinality("businessDayConvention", (BusinessDayConventionEnum) o.getBusinessDayConvention() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<DaysModel> validate(RosettaPath path, DaysModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DaysModel", ValidationType.CARDINALITY, "DaysModel", path, "", error);
		}
		return success("DaysModel", ValidationType.CARDINALITY, "DaysModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DaysModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DaysModel", ValidationType.CARDINALITY, "DaysModel", path, "", res.getError());
				}
				return success("DaysModel", ValidationType.CARDINALITY, "DaysModel", path, "");
			})
			.collect(toList());
	}

}
