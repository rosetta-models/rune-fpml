package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxDigitalAmericanExercise;
import fpml.confirmation.FxDigitalOptionSequence0;
import fpml.confirmation.FxTouch;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxDigitalOptionSequence0Validator implements Validator<FxDigitalOptionSequence0> {

	private List<ComparisonResult> getComparisonResults(FxDigitalOptionSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("americanExercise", (FxDigitalAmericanExercise) o.getAmericanExercise() != null ? 1 : 0, 1, 1), 
				checkCardinality("touch", (List<? extends FxTouch>) o.getTouch() == null ? 0 : ((List<? extends FxTouch>) o.getTouch()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<FxDigitalOptionSequence0> validate(RosettaPath path, FxDigitalOptionSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxDigitalOptionSequence0", ValidationType.CARDINALITY, "FxDigitalOptionSequence0", path, "", error);
		}
		return success("FxDigitalOptionSequence0", ValidationType.CARDINALITY, "FxDigitalOptionSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxDigitalOptionSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxDigitalOptionSequence0", ValidationType.CARDINALITY, "FxDigitalOptionSequence0", path, "", res.getError());
				}
				return success("FxDigitalOptionSequence0", ValidationType.CARDINALITY, "FxDigitalOptionSequence0", path, "");
			})
			.collect(toList());
	}

}
