package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EvergreenOption;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EvergreenOptionTypeFormatValidator implements Validator<EvergreenOption> {

	private List<ComparisonResult> getComparisonResults(EvergreenOption o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<EvergreenOption> validate(RosettaPath path, EvergreenOption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EvergreenOption", ValidationType.TYPE_FORMAT, "EvergreenOption", path, "", error);
		}
		return success("EvergreenOption", ValidationType.TYPE_FORMAT, "EvergreenOption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EvergreenOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EvergreenOption", ValidationType.TYPE_FORMAT, "EvergreenOption", path, "", res.getError());
				}
				return success("EvergreenOption", ValidationType.TYPE_FORMAT, "EvergreenOption", path, "");
			})
			.collect(toList());
	}

}
