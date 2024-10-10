package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LegalEntitySequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LegalEntitySequenceTypeFormatValidator implements Validator<LegalEntitySequence> {

	private List<ComparisonResult> getComparisonResults(LegalEntitySequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LegalEntitySequence> validate(RosettaPath path, LegalEntitySequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LegalEntitySequence", ValidationType.TYPE_FORMAT, "LegalEntitySequence", path, "", error);
		}
		return success("LegalEntitySequence", ValidationType.TYPE_FORMAT, "LegalEntitySequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegalEntitySequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegalEntitySequence", ValidationType.TYPE_FORMAT, "LegalEntitySequence", path, "", res.getError());
				}
				return success("LegalEntitySequence", ValidationType.TYPE_FORMAT, "LegalEntitySequence", path, "");
			})
			.collect(toList());
	}

}
