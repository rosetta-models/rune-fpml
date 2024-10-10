package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CorrelationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CorrelationModelTypeFormatValidator implements Validator<CorrelationModel> {

	private List<ComparisonResult> getComparisonResults(CorrelationModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CorrelationModel> validate(RosettaPath path, CorrelationModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CorrelationModel", ValidationType.TYPE_FORMAT, "CorrelationModel", path, "", error);
		}
		return success("CorrelationModel", ValidationType.TYPE_FORMAT, "CorrelationModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CorrelationModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CorrelationModel", ValidationType.TYPE_FORMAT, "CorrelationModel", path, "", res.getError());
				}
				return success("CorrelationModel", ValidationType.TYPE_FORMAT, "CorrelationModel", path, "");
			})
			.collect(toList());
	}

}
