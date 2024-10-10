package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.DayTypeEnum;
import fpml.confirmation.ParametricScheduleModelSequence2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ParametricScheduleModelSequence2Validator implements Validator<ParametricScheduleModelSequence2> {

	private List<ComparisonResult> getComparisonResults(ParametricScheduleModelSequence2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dayType", (DayTypeEnum) o.getDayType() != null ? 1 : 0, 1, 1), 
				checkCardinality("businessCentersOrReferenceModel", (BusinessCentersOrReferenceModel) o.getBusinessCentersOrReferenceModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ParametricScheduleModelSequence2> validate(RosettaPath path, ParametricScheduleModelSequence2 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ParametricScheduleModelSequence2", ValidationType.CARDINALITY, "ParametricScheduleModelSequence2", path, "", error);
		}
		return success("ParametricScheduleModelSequence2", ValidationType.CARDINALITY, "ParametricScheduleModelSequence2", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ParametricScheduleModelSequence2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ParametricScheduleModelSequence2", ValidationType.CARDINALITY, "ParametricScheduleModelSequence2", path, "", res.getError());
				}
				return success("ParametricScheduleModelSequence2", ValidationType.CARDINALITY, "ParametricScheduleModelSequence2", path, "");
			})
			.collect(toList());
	}

}
