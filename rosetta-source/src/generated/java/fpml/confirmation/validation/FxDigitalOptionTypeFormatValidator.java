package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxDigitalOption;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxDigitalOptionTypeFormatValidator implements Validator<FxDigitalOption> {

	private List<ComparisonResult> getComparisonResults(FxDigitalOption o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxDigitalOption> validate(RosettaPath path, FxDigitalOption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxDigitalOption", ValidationType.TYPE_FORMAT, "FxDigitalOption", path, "", error);
		}
		return success("FxDigitalOption", ValidationType.TYPE_FORMAT, "FxDigitalOption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxDigitalOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxDigitalOption", ValidationType.TYPE_FORMAT, "FxDigitalOption", path, "", res.getError());
				}
				return success("FxDigitalOption", ValidationType.TYPE_FORMAT, "FxDigitalOption", path, "");
			})
			.collect(toList());
	}

}
