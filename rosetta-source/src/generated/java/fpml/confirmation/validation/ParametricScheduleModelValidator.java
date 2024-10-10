package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ParametricScheduleModel;
import fpml.confirmation.ParametricScheduleModelSequence0;
import fpml.confirmation.ParametricScheduleModelSequence1;
import fpml.confirmation.ParametricScheduleModelSequence2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ParametricScheduleModelValidator implements Validator<ParametricScheduleModel> {

	private List<ComparisonResult> getComparisonResults(ParametricScheduleModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("parametricScheduleModelSequence0", (ParametricScheduleModelSequence0) o.getParametricScheduleModelSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("endDate", (Date) o.getEndDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("parametricScheduleModelSequence1", (ParametricScheduleModelSequence1) o.getParametricScheduleModelSequence1() != null ? 1 : 0, 0, 1), 
				checkCardinality("parametricScheduleModelSequence2", (ParametricScheduleModelSequence2) o.getParametricScheduleModelSequence2() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ParametricScheduleModel> validate(RosettaPath path, ParametricScheduleModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ParametricScheduleModel", ValidationType.CARDINALITY, "ParametricScheduleModel", path, "", error);
		}
		return success("ParametricScheduleModel", ValidationType.CARDINALITY, "ParametricScheduleModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ParametricScheduleModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ParametricScheduleModel", ValidationType.CARDINALITY, "ParametricScheduleModel", path, "", res.getError());
				}
				return success("ParametricScheduleModel", ValidationType.CARDINALITY, "ParametricScheduleModel", path, "");
			})
			.collect(toList());
	}

}
