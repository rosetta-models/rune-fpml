package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NotionalReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NotionalReferenceTypeFormatValidator implements Validator<NotionalReference> {

	private List<ComparisonResult> getComparisonResults(NotionalReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<NotionalReference> validate(RosettaPath path, NotionalReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NotionalReference", ValidationType.TYPE_FORMAT, "NotionalReference", path, "", error);
		}
		return success("NotionalReference", ValidationType.TYPE_FORMAT, "NotionalReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotionalReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NotionalReference", ValidationType.TYPE_FORMAT, "NotionalReference", path, "", res.getError());
				}
				return success("NotionalReference", ValidationType.TYPE_FORMAT, "NotionalReference", path, "");
			})
			.collect(toList());
	}

}
