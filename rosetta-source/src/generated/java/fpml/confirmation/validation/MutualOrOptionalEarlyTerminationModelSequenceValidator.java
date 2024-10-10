package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EarlyTerminationDateEnum;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModelSequence;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModelSequenceSequence;
import fpml.confirmation.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MutualOrOptionalEarlyTerminationModelSequenceValidator implements Validator<MutualOrOptionalEarlyTerminationModelSequence> {

	private List<ComparisonResult> getComparisonResults(MutualOrOptionalEarlyTerminationModelSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("optionalEarlyTermination", (Boolean) o.getOptionalEarlyTermination() != null ? 1 : 0, 1, 1), 
				checkCardinality("optionalEarlyTerminationDate", (EarlyTerminationDateEnum) o.getOptionalEarlyTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionalEarlyTerminationElectingPartyReference", (PartyReference) o.getOptionalEarlyTerminationElectingPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("breakFundingRecovery", (Boolean) o.getBreakFundingRecovery() != null ? 1 : 0, 0, 1), 
				checkCardinality("mutualOrOptionalEarlyTerminationModelSequenceSequence", (MutualOrOptionalEarlyTerminationModelSequenceSequence) o.getMutualOrOptionalEarlyTerminationModelSequenceSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<MutualOrOptionalEarlyTerminationModelSequence> validate(RosettaPath path, MutualOrOptionalEarlyTerminationModelSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MutualOrOptionalEarlyTerminationModelSequence", ValidationType.CARDINALITY, "MutualOrOptionalEarlyTerminationModelSequence", path, "", error);
		}
		return success("MutualOrOptionalEarlyTerminationModelSequence", ValidationType.CARDINALITY, "MutualOrOptionalEarlyTerminationModelSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MutualOrOptionalEarlyTerminationModelSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MutualOrOptionalEarlyTerminationModelSequence", ValidationType.CARDINALITY, "MutualOrOptionalEarlyTerminationModelSequence", path, "", res.getError());
				}
				return success("MutualOrOptionalEarlyTerminationModelSequence", ValidationType.CARDINALITY, "MutualOrOptionalEarlyTerminationModelSequence", path, "");
			})
			.collect(toList());
	}

}
