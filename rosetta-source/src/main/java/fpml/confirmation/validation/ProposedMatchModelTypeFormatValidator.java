package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ProposedMatchModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ProposedMatchModelTypeFormatValidator implements Validator<ProposedMatchModel> {

	private List<ComparisonResult> getComparisonResults(ProposedMatchModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ProposedMatchModel> validate(RosettaPath path, ProposedMatchModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ProposedMatchModel", ValidationType.TYPE_FORMAT, "ProposedMatchModel", path, "", error);
		}
		return success("ProposedMatchModel", ValidationType.TYPE_FORMAT, "ProposedMatchModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProposedMatchModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProposedMatchModel", ValidationType.TYPE_FORMAT, "ProposedMatchModel", path, "", res.getError());
				}
				return success("ProposedMatchModel", ValidationType.TYPE_FORMAT, "ProposedMatchModel", path, "");
			})
			.collect(toList());
	}

}
