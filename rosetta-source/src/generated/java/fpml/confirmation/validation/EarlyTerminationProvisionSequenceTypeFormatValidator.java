package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EarlyTerminationProvisionSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EarlyTerminationProvisionSequenceTypeFormatValidator implements Validator<EarlyTerminationProvisionSequence> {

	private List<ComparisonResult> getComparisonResults(EarlyTerminationProvisionSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<EarlyTerminationProvisionSequence> validate(RosettaPath path, EarlyTerminationProvisionSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EarlyTerminationProvisionSequence", ValidationType.TYPE_FORMAT, "EarlyTerminationProvisionSequence", path, "", error);
		}
		return success("EarlyTerminationProvisionSequence", ValidationType.TYPE_FORMAT, "EarlyTerminationProvisionSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EarlyTerminationProvisionSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EarlyTerminationProvisionSequence", ValidationType.TYPE_FORMAT, "EarlyTerminationProvisionSequence", path, "", res.getError());
				}
				return success("EarlyTerminationProvisionSequence", ValidationType.TYPE_FORMAT, "EarlyTerminationProvisionSequence", path, "");
			})
			.collect(toList());
	}

}
