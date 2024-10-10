package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.UnprocessedElementWrapper;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class UnprocessedElementWrapperTypeFormatValidator implements Validator<UnprocessedElementWrapper> {

	private List<ComparisonResult> getComparisonResults(UnprocessedElementWrapper o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<UnprocessedElementWrapper> validate(RosettaPath path, UnprocessedElementWrapper o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("UnprocessedElementWrapper", ValidationType.TYPE_FORMAT, "UnprocessedElementWrapper", path, "", error);
		}
		return success("UnprocessedElementWrapper", ValidationType.TYPE_FORMAT, "UnprocessedElementWrapper", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UnprocessedElementWrapper o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UnprocessedElementWrapper", ValidationType.TYPE_FORMAT, "UnprocessedElementWrapper", path, "", res.getError());
				}
				return success("UnprocessedElementWrapper", ValidationType.TYPE_FORMAT, "UnprocessedElementWrapper", path, "");
			})
			.collect(toList());
	}

}
