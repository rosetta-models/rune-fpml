package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CurrentPriorCommitmentModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CurrentPriorCommitmentModelTypeFormatValidator implements Validator<CurrentPriorCommitmentModel> {

	private List<ComparisonResult> getComparisonResults(CurrentPriorCommitmentModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CurrentPriorCommitmentModel> validate(RosettaPath path, CurrentPriorCommitmentModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CurrentPriorCommitmentModel", ValidationType.TYPE_FORMAT, "CurrentPriorCommitmentModel", path, "", error);
		}
		return success("CurrentPriorCommitmentModel", ValidationType.TYPE_FORMAT, "CurrentPriorCommitmentModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CurrentPriorCommitmentModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CurrentPriorCommitmentModel", ValidationType.TYPE_FORMAT, "CurrentPriorCommitmentModel", path, "", res.getError());
				}
				return success("CurrentPriorCommitmentModel", ValidationType.TYPE_FORMAT, "CurrentPriorCommitmentModel", path, "");
			})
			.collect(toList());
	}

}
