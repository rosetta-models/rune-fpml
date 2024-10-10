package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ExceptionModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ExceptionModelTypeFormatValidator implements Validator<ExceptionModel> {

	private List<ComparisonResult> getComparisonResults(ExceptionModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ExceptionModel> validate(RosettaPath path, ExceptionModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ExceptionModel", ValidationType.TYPE_FORMAT, "ExceptionModel", path, "", error);
		}
		return success("ExceptionModel", ValidationType.TYPE_FORMAT, "ExceptionModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExceptionModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExceptionModel", ValidationType.TYPE_FORMAT, "ExceptionModel", path, "", res.getError());
				}
				return success("ExceptionModel", ValidationType.TYPE_FORMAT, "ExceptionModel", path, "");
			})
			.collect(toList());
	}

}
