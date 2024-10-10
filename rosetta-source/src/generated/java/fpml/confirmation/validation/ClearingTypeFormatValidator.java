package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Clearing;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ClearingTypeFormatValidator implements Validator<Clearing> {

	private List<ComparisonResult> getComparisonResults(Clearing o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Clearing> validate(RosettaPath path, Clearing o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Clearing", ValidationType.TYPE_FORMAT, "Clearing", path, "", error);
		}
		return success("Clearing", ValidationType.TYPE_FORMAT, "Clearing", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Clearing o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Clearing", ValidationType.TYPE_FORMAT, "Clearing", path, "", res.getError());
				}
				return success("Clearing", ValidationType.TYPE_FORMAT, "Clearing", path, "");
			})
			.collect(toList());
	}

}
