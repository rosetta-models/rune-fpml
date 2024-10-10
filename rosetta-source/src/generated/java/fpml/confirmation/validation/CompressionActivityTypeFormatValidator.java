package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CompressionActivity;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CompressionActivityTypeFormatValidator implements Validator<CompressionActivity> {

	private List<ComparisonResult> getComparisonResults(CompressionActivity o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CompressionActivity> validate(RosettaPath path, CompressionActivity o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CompressionActivity", ValidationType.TYPE_FORMAT, "CompressionActivity", path, "", error);
		}
		return success("CompressionActivity", ValidationType.TYPE_FORMAT, "CompressionActivity", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CompressionActivity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CompressionActivity", ValidationType.TYPE_FORMAT, "CompressionActivity", path, "", res.getError());
				}
				return success("CompressionActivity", ValidationType.TYPE_FORMAT, "CompressionActivity", path, "");
			})
			.collect(toList());
	}

}
