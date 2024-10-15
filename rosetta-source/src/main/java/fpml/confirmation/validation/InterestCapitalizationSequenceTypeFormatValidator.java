package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InterestCapitalizationSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InterestCapitalizationSequenceTypeFormatValidator implements Validator<InterestCapitalizationSequence> {

	private List<ComparisonResult> getComparisonResults(InterestCapitalizationSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<InterestCapitalizationSequence> validate(RosettaPath path, InterestCapitalizationSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InterestCapitalizationSequence", ValidationType.TYPE_FORMAT, "InterestCapitalizationSequence", path, "", error);
		}
		return success("InterestCapitalizationSequence", ValidationType.TYPE_FORMAT, "InterestCapitalizationSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestCapitalizationSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestCapitalizationSequence", ValidationType.TYPE_FORMAT, "InterestCapitalizationSequence", path, "", res.getError());
				}
				return success("InterestCapitalizationSequence", ValidationType.TYPE_FORMAT, "InterestCapitalizationSequence", path, "");
			})
			.collect(toList());
	}

}
