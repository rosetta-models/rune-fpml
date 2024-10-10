package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EquityEuropeanExercise;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquityEuropeanExerciseTypeFormatValidator implements Validator<EquityEuropeanExercise> {

	private List<ComparisonResult> getComparisonResults(EquityEuropeanExercise o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<EquityEuropeanExercise> validate(RosettaPath path, EquityEuropeanExercise o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquityEuropeanExercise", ValidationType.TYPE_FORMAT, "EquityEuropeanExercise", path, "", error);
		}
		return success("EquityEuropeanExercise", ValidationType.TYPE_FORMAT, "EquityEuropeanExercise", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityEuropeanExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityEuropeanExercise", ValidationType.TYPE_FORMAT, "EquityEuropeanExercise", path, "", res.getError());
				}
				return success("EquityEuropeanExercise", ValidationType.TYPE_FORMAT, "EquityEuropeanExercise", path, "");
			})
			.collect(toList());
	}

}
