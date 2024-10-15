package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ValidationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ValidationModelTypeFormatValidator implements Validator<ValidationModel> {

	private List<ComparisonResult> getComparisonResults(ValidationModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ValidationModel> validate(RosettaPath path, ValidationModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ValidationModel", ValidationType.TYPE_FORMAT, "ValidationModel", path, "", error);
		}
		return success("ValidationModel", ValidationType.TYPE_FORMAT, "ValidationModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValidationModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValidationModel", ValidationType.TYPE_FORMAT, "ValidationModel", path, "", res.getError());
				}
				return success("ValidationModel", ValidationType.TYPE_FORMAT, "ValidationModel", path, "");
			})
			.collect(toList());
	}

}
