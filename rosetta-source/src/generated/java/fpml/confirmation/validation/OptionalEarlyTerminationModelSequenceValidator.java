package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ExercisePeriod;
import fpml.confirmation.OptionalEarlyTermination;
import fpml.confirmation.OptionalEarlyTerminationModelSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionalEarlyTerminationModelSequenceValidator implements Validator<OptionalEarlyTerminationModelSequence> {

	private List<ComparisonResult> getComparisonResults(OptionalEarlyTerminationModelSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("optionalEarlyTerminationParameters", (ExercisePeriod) o.getOptionalEarlyTerminationParameters() != null ? 1 : 0, 1, 1), 
				checkCardinality("optionalEarlyTermination", (OptionalEarlyTermination) o.getOptionalEarlyTermination() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OptionalEarlyTerminationModelSequence> validate(RosettaPath path, OptionalEarlyTerminationModelSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionalEarlyTerminationModelSequence", ValidationType.CARDINALITY, "OptionalEarlyTerminationModelSequence", path, "", error);
		}
		return success("OptionalEarlyTerminationModelSequence", ValidationType.CARDINALITY, "OptionalEarlyTerminationModelSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionalEarlyTerminationModelSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionalEarlyTerminationModelSequence", ValidationType.CARDINALITY, "OptionalEarlyTerminationModelSequence", path, "", res.getError());
				}
				return success("OptionalEarlyTerminationModelSequence", ValidationType.CARDINALITY, "OptionalEarlyTerminationModelSequence", path, "");
			})
			.collect(toList());
	}

}
