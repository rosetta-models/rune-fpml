package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RepoNearLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RepoNearLegTypeFormatValidator implements Validator<RepoNearLeg> {

	private List<ComparisonResult> getComparisonResults(RepoNearLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<RepoNearLeg> validate(RosettaPath path, RepoNearLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RepoNearLeg", ValidationType.TYPE_FORMAT, "RepoNearLeg", path, "", error);
		}
		return success("RepoNearLeg", ValidationType.TYPE_FORMAT, "RepoNearLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RepoNearLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RepoNearLeg", ValidationType.TYPE_FORMAT, "RepoNearLeg", path, "", res.getError());
				}
				return success("RepoNearLeg", ValidationType.TYPE_FORMAT, "RepoNearLeg", path, "");
			})
			.collect(toList());
	}

}
