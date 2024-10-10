package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MandatoryEarlyTerminationModelSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MandatoryEarlyTerminationModelSequenceTypeFormatValidator implements Validator<MandatoryEarlyTerminationModelSequence> {

	private List<ComparisonResult> getComparisonResults(MandatoryEarlyTerminationModelSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<MandatoryEarlyTerminationModelSequence> validate(RosettaPath path, MandatoryEarlyTerminationModelSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MandatoryEarlyTerminationModelSequence", ValidationType.TYPE_FORMAT, "MandatoryEarlyTerminationModelSequence", path, "", error);
		}
		return success("MandatoryEarlyTerminationModelSequence", ValidationType.TYPE_FORMAT, "MandatoryEarlyTerminationModelSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MandatoryEarlyTerminationModelSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MandatoryEarlyTerminationModelSequence", ValidationType.TYPE_FORMAT, "MandatoryEarlyTerminationModelSequence", path, "", res.getError());
				}
				return success("MandatoryEarlyTerminationModelSequence", ValidationType.TYPE_FORMAT, "MandatoryEarlyTerminationModelSequence", path, "");
			})
			.collect(toList());
	}

}
