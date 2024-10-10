package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InterestAccrualsCompoundingMethodSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InterestAccrualsCompoundingMethodSequenceTypeFormatValidator implements Validator<InterestAccrualsCompoundingMethodSequence> {

	private List<ComparisonResult> getComparisonResults(InterestAccrualsCompoundingMethodSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<InterestAccrualsCompoundingMethodSequence> validate(RosettaPath path, InterestAccrualsCompoundingMethodSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InterestAccrualsCompoundingMethodSequence", ValidationType.TYPE_FORMAT, "InterestAccrualsCompoundingMethodSequence", path, "", error);
		}
		return success("InterestAccrualsCompoundingMethodSequence", ValidationType.TYPE_FORMAT, "InterestAccrualsCompoundingMethodSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestAccrualsCompoundingMethodSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestAccrualsCompoundingMethodSequence", ValidationType.TYPE_FORMAT, "InterestAccrualsCompoundingMethodSequence", path, "", res.getError());
				}
				return success("InterestAccrualsCompoundingMethodSequence", ValidationType.TYPE_FORMAT, "InterestAccrualsCompoundingMethodSequence", path, "");
			})
			.collect(toList());
	}

}
