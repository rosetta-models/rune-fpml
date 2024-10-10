package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CorrelationAndOptionalSequenceModelTypeFormatValidator implements Validator<CorrelationAndOptionalSequenceModel> {

	private List<ComparisonResult> getComparisonResults(CorrelationAndOptionalSequenceModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CorrelationAndOptionalSequenceModel> validate(RosettaPath path, CorrelationAndOptionalSequenceModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CorrelationAndOptionalSequenceModel", ValidationType.TYPE_FORMAT, "CorrelationAndOptionalSequenceModel", path, "", error);
		}
		return success("CorrelationAndOptionalSequenceModel", ValidationType.TYPE_FORMAT, "CorrelationAndOptionalSequenceModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CorrelationAndOptionalSequenceModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CorrelationAndOptionalSequenceModel", ValidationType.TYPE_FORMAT, "CorrelationAndOptionalSequenceModel", path, "", res.getError());
				}
				return success("CorrelationAndOptionalSequenceModel", ValidationType.TYPE_FORMAT, "CorrelationAndOptionalSequenceModel", path, "");
			})
			.collect(toList());
	}

}
