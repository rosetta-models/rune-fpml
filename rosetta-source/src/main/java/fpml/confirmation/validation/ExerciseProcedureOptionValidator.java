package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Empty;
import fpml.confirmation.ExerciseProcedureOption;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ExerciseProcedureOptionValidator implements Validator<ExerciseProcedureOption> {

	private List<ComparisonResult> getComparisonResults(ExerciseProcedureOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("manualExercise", (Empty) o.getManualExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("automaticExercise", (Empty) o.getAutomaticExercise() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ExerciseProcedureOption> validate(RosettaPath path, ExerciseProcedureOption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ExerciseProcedureOption", ValidationType.CARDINALITY, "ExerciseProcedureOption", path, "", error);
		}
		return success("ExerciseProcedureOption", ValidationType.CARDINALITY, "ExerciseProcedureOption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseProcedureOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExerciseProcedureOption", ValidationType.CARDINALITY, "ExerciseProcedureOption", path, "", res.getError());
				}
				return success("ExerciseProcedureOption", ValidationType.CARDINALITY, "ExerciseProcedureOption", path, "");
			})
			.collect(toList());
	}

}
