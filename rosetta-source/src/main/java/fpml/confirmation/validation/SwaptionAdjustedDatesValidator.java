package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ExerciseEvent;
import fpml.confirmation.SwaptionAdjustedDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SwaptionAdjustedDatesValidator implements Validator<SwaptionAdjustedDates> {

	private List<ComparisonResult> getComparisonResults(SwaptionAdjustedDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("exerciseEvent", (List<? extends ExerciseEvent>) o.getExerciseEvent() == null ? 0 : ((List<? extends ExerciseEvent>) o.getExerciseEvent()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<SwaptionAdjustedDates> validate(RosettaPath path, SwaptionAdjustedDates o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SwaptionAdjustedDates", ValidationType.CARDINALITY, "SwaptionAdjustedDates", path, "", error);
		}
		return success("SwaptionAdjustedDates", ValidationType.CARDINALITY, "SwaptionAdjustedDates", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SwaptionAdjustedDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SwaptionAdjustedDates", ValidationType.CARDINALITY, "SwaptionAdjustedDates", path, "", res.getError());
				}
				return success("SwaptionAdjustedDates", ValidationType.CARDINALITY, "SwaptionAdjustedDates", path, "");
			})
			.collect(toList());
	}

}
