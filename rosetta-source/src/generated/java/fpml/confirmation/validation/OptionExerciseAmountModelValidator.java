package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ExerciseActionEnum;
import fpml.confirmation.OptionExerciseAmountModel;
import fpml.confirmation.OptionExerciseAmountModelSequence0;
import fpml.confirmation.OptionExerciseAmountModelSequence1;
import fpml.confirmation.OptionExerciseAmountModelSequence2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionExerciseAmountModelValidator implements Validator<OptionExerciseAmountModel> {

	private List<ComparisonResult> getComparisonResults(OptionExerciseAmountModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("exerciseAction", (ExerciseActionEnum) o.getExerciseAction() != null ? 1 : 0, 0, 1), 
				checkCardinality("expiry", (Boolean) o.getExpiry() != null ? 1 : 0, 0, 1), 
				checkCardinality("fullExercise", (Boolean) o.getFullExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionExerciseAmountModelSequence0", (OptionExerciseAmountModelSequence0) o.getOptionExerciseAmountModelSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionExerciseAmountModelSequence1", (OptionExerciseAmountModelSequence1) o.getOptionExerciseAmountModelSequence1() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionExerciseAmountModelSequence2", (OptionExerciseAmountModelSequence2) o.getOptionExerciseAmountModelSequence2() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OptionExerciseAmountModel> validate(RosettaPath path, OptionExerciseAmountModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionExerciseAmountModel", ValidationType.CARDINALITY, "OptionExerciseAmountModel", path, "", error);
		}
		return success("OptionExerciseAmountModel", ValidationType.CARDINALITY, "OptionExerciseAmountModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExerciseAmountModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionExerciseAmountModel", ValidationType.CARDINALITY, "OptionExerciseAmountModel", path, "", res.getError());
				}
				return success("OptionExerciseAmountModel", ValidationType.CARDINALITY, "OptionExerciseAmountModel", path, "");
			})
			.collect(toList());
	}

}
