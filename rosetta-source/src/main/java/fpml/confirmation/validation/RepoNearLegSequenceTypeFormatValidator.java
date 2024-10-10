package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RepoNearLegSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RepoNearLegSequenceTypeFormatValidator implements Validator<RepoNearLegSequence> {

	private List<ComparisonResult> getComparisonResults(RepoNearLegSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<RepoNearLegSequence> validate(RosettaPath path, RepoNearLegSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RepoNearLegSequence", ValidationType.TYPE_FORMAT, "RepoNearLegSequence", path, "", error);
		}
		return success("RepoNearLegSequence", ValidationType.TYPE_FORMAT, "RepoNearLegSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RepoNearLegSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RepoNearLegSequence", ValidationType.TYPE_FORMAT, "RepoNearLegSequence", path, "", res.getError());
				}
				return success("RepoNearLegSequence", ValidationType.TYPE_FORMAT, "RepoNearLegSequence", path, "");
			})
			.collect(toList());
	}

}
