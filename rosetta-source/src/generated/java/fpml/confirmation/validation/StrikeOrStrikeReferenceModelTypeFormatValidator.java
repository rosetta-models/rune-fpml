package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.StrikeOrStrikeReferenceModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StrikeOrStrikeReferenceModelTypeFormatValidator implements Validator<StrikeOrStrikeReferenceModel> {

	private List<ComparisonResult> getComparisonResults(StrikeOrStrikeReferenceModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<StrikeOrStrikeReferenceModel> validate(RosettaPath path, StrikeOrStrikeReferenceModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("StrikeOrStrikeReferenceModel", ValidationType.TYPE_FORMAT, "StrikeOrStrikeReferenceModel", path, "", error);
		}
		return success("StrikeOrStrikeReferenceModel", ValidationType.TYPE_FORMAT, "StrikeOrStrikeReferenceModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StrikeOrStrikeReferenceModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StrikeOrStrikeReferenceModel", ValidationType.TYPE_FORMAT, "StrikeOrStrikeReferenceModel", path, "", res.getError());
				}
				return success("StrikeOrStrikeReferenceModel", ValidationType.TYPE_FORMAT, "StrikeOrStrikeReferenceModel", path, "");
			})
			.collect(toList());
	}

}
