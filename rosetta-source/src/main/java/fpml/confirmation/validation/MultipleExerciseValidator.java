package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MultipleExercise;
import fpml.confirmation.PartialExerciseModel;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MultipleExerciseValidator implements Validator<MultipleExercise> {

	private List<ComparisonResult> getComparisonResults(MultipleExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partialExerciseModel", (PartialExerciseModel) o.getPartialExerciseModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("maximumNotionalAmount", (BigDecimal) o.getMaximumNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("maximumNumberOfOptions", (BigDecimal) o.getMaximumNumberOfOptions() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<MultipleExercise> validate(RosettaPath path, MultipleExercise o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MultipleExercise", ValidationType.CARDINALITY, "MultipleExercise", path, "", error);
		}
		return success("MultipleExercise", ValidationType.CARDINALITY, "MultipleExercise", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MultipleExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MultipleExercise", ValidationType.CARDINALITY, "MultipleExercise", path, "", res.getError());
				}
				return success("MultipleExercise", ValidationType.CARDINALITY, "MultipleExercise", path, "");
			})
			.collect(toList());
	}

}
