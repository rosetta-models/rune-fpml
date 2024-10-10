package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.ObservationFrequency;
import fpml.confirmation.ParametricScheduleModelSequence1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ParametricScheduleModelSequence1Validator implements Validator<ParametricScheduleModelSequence1> {

	private List<ComparisonResult> getComparisonResults(ParametricScheduleModelSequence1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("observationFrequency", (ObservationFrequency) o.getObservationFrequency() != null ? 1 : 0, 1, 1), 
				checkCardinality("dateAdjustments", (BusinessDayAdjustments) o.getDateAdjustments() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ParametricScheduleModelSequence1> validate(RosettaPath path, ParametricScheduleModelSequence1 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ParametricScheduleModelSequence1", ValidationType.CARDINALITY, "ParametricScheduleModelSequence1", path, "", error);
		}
		return success("ParametricScheduleModelSequence1", ValidationType.CARDINALITY, "ParametricScheduleModelSequence1", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ParametricScheduleModelSequence1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ParametricScheduleModelSequence1", ValidationType.CARDINALITY, "ParametricScheduleModelSequence1", path, "", res.getError());
				}
				return success("ParametricScheduleModelSequence1", ValidationType.CARDINALITY, "ParametricScheduleModelSequence1", path, "");
			})
			.collect(toList());
	}

}
