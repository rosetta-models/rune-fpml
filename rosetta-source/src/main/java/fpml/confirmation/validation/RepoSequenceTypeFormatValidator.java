package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RepoSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RepoSequenceTypeFormatValidator implements Validator<RepoSequence> {

	private List<ComparisonResult> getComparisonResults(RepoSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<RepoSequence> validate(RosettaPath path, RepoSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RepoSequence", ValidationType.TYPE_FORMAT, "RepoSequence", path, "", error);
		}
		return success("RepoSequence", ValidationType.TYPE_FORMAT, "RepoSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RepoSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RepoSequence", ValidationType.TYPE_FORMAT, "RepoSequence", path, "", res.getError());
				}
				return success("RepoSequence", ValidationType.TYPE_FORMAT, "RepoSequence", path, "");
			})
			.collect(toList());
	}

}
