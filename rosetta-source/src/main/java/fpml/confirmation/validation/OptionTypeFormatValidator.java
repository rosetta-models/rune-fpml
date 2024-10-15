package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Option;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionTypeFormatValidator implements Validator<Option> {

	private List<ComparisonResult> getComparisonResults(Option o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Option> validate(RosettaPath path, Option o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Option", ValidationType.TYPE_FORMAT, "Option", path, "", error);
		}
		return success("Option", ValidationType.TYPE_FORMAT, "Option", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Option o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Option", ValidationType.TYPE_FORMAT, "Option", path, "", res.getError());
				}
				return success("Option", ValidationType.TYPE_FORMAT, "Option", path, "");
			})
			.collect(toList());
	}

}
