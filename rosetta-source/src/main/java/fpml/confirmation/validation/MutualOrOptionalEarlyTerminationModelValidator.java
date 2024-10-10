package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModel;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModelSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MutualOrOptionalEarlyTerminationModelValidator implements Validator<MutualOrOptionalEarlyTerminationModel> {

	private List<ComparisonResult> getComparisonResults(MutualOrOptionalEarlyTerminationModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("mutualEarlyTermination", (Boolean) o.getMutualEarlyTermination() != null ? 1 : 0, 0, 1), 
				checkCardinality("mutualOrOptionalEarlyTerminationModelSequence", (MutualOrOptionalEarlyTerminationModelSequence) o.getMutualOrOptionalEarlyTerminationModelSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<MutualOrOptionalEarlyTerminationModel> validate(RosettaPath path, MutualOrOptionalEarlyTerminationModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MutualOrOptionalEarlyTerminationModel", ValidationType.CARDINALITY, "MutualOrOptionalEarlyTerminationModel", path, "", error);
		}
		return success("MutualOrOptionalEarlyTerminationModel", ValidationType.CARDINALITY, "MutualOrOptionalEarlyTerminationModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MutualOrOptionalEarlyTerminationModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MutualOrOptionalEarlyTerminationModel", ValidationType.CARDINALITY, "MutualOrOptionalEarlyTerminationModel", path, "", res.getError());
				}
				return success("MutualOrOptionalEarlyTerminationModel", ValidationType.CARDINALITY, "MutualOrOptionalEarlyTerminationModel", path, "");
			})
			.collect(toList());
	}

}
