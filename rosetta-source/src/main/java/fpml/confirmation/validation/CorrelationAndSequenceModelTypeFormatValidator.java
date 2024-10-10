package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CorrelationAndSequenceModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CorrelationAndSequenceModelTypeFormatValidator implements Validator<CorrelationAndSequenceModel> {

	private List<ComparisonResult> getComparisonResults(CorrelationAndSequenceModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CorrelationAndSequenceModel> validate(RosettaPath path, CorrelationAndSequenceModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CorrelationAndSequenceModel", ValidationType.TYPE_FORMAT, "CorrelationAndSequenceModel", path, "", error);
		}
		return success("CorrelationAndSequenceModel", ValidationType.TYPE_FORMAT, "CorrelationAndSequenceModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CorrelationAndSequenceModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CorrelationAndSequenceModel", ValidationType.TYPE_FORMAT, "CorrelationAndSequenceModel", path, "", res.getError());
				}
				return success("CorrelationAndSequenceModel", ValidationType.TYPE_FORMAT, "CorrelationAndSequenceModel", path, "");
			})
			.collect(toList());
	}

}
