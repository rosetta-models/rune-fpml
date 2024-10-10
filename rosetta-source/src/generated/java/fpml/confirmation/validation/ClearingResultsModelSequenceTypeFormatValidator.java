package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ClearingResultsModelSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ClearingResultsModelSequenceTypeFormatValidator implements Validator<ClearingResultsModelSequence> {

	private List<ComparisonResult> getComparisonResults(ClearingResultsModelSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ClearingResultsModelSequence> validate(RosettaPath path, ClearingResultsModelSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ClearingResultsModelSequence", ValidationType.TYPE_FORMAT, "ClearingResultsModelSequence", path, "", error);
		}
		return success("ClearingResultsModelSequence", ValidationType.TYPE_FORMAT, "ClearingResultsModelSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingResultsModelSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingResultsModelSequence", ValidationType.TYPE_FORMAT, "ClearingResultsModelSequence", path, "", res.getError());
				}
				return success("ClearingResultsModelSequence", ValidationType.TYPE_FORMAT, "ClearingResultsModelSequence", path, "");
			})
			.collect(toList());
	}

}
