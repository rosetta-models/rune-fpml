package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OptionalEarlyTermination;
import fpml.confirmation.OptionalEarlyTerminationModel;
import fpml.confirmation.OptionalEarlyTerminationModelSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionalEarlyTerminationModelValidator implements Validator<OptionalEarlyTerminationModel> {

	private List<ComparisonResult> getComparisonResults(OptionalEarlyTerminationModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("optionalEarlyTermination", (OptionalEarlyTermination) o.getOptionalEarlyTermination() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionalEarlyTerminationModelSequence", (OptionalEarlyTerminationModelSequence) o.getOptionalEarlyTerminationModelSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OptionalEarlyTerminationModel> validate(RosettaPath path, OptionalEarlyTerminationModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionalEarlyTerminationModel", ValidationType.CARDINALITY, "OptionalEarlyTerminationModel", path, "", error);
		}
		return success("OptionalEarlyTerminationModel", ValidationType.CARDINALITY, "OptionalEarlyTerminationModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionalEarlyTerminationModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionalEarlyTerminationModel", ValidationType.CARDINALITY, "OptionalEarlyTerminationModel", path, "", res.getError());
				}
				return success("OptionalEarlyTerminationModel", ValidationType.CARDINALITY, "OptionalEarlyTerminationModel", path, "");
			})
			.collect(toList());
	}

}
