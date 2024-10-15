package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RepoFarLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RepoFarLegTypeFormatValidator implements Validator<RepoFarLeg> {

	private List<ComparisonResult> getComparisonResults(RepoFarLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<RepoFarLeg> validate(RosettaPath path, RepoFarLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RepoFarLeg", ValidationType.TYPE_FORMAT, "RepoFarLeg", path, "", error);
		}
		return success("RepoFarLeg", ValidationType.TYPE_FORMAT, "RepoFarLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RepoFarLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RepoFarLeg", ValidationType.TYPE_FORMAT, "RepoFarLeg", path, "", res.getError());
				}
				return success("RepoFarLeg", ValidationType.TYPE_FORMAT, "RepoFarLeg", path, "");
			})
			.collect(toList());
	}

}
