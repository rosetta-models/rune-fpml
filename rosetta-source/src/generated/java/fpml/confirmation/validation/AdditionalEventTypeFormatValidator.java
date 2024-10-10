package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdditionalEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AdditionalEventTypeFormatValidator implements Validator<AdditionalEvent> {

	private List<ComparisonResult> getComparisonResults(AdditionalEvent o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<AdditionalEvent> validate(RosettaPath path, AdditionalEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AdditionalEvent", ValidationType.TYPE_FORMAT, "AdditionalEvent", path, "", error);
		}
		return success("AdditionalEvent", ValidationType.TYPE_FORMAT, "AdditionalEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdditionalEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdditionalEvent", ValidationType.TYPE_FORMAT, "AdditionalEvent", path, "", res.getError());
				}
				return success("AdditionalEvent", ValidationType.TYPE_FORMAT, "AdditionalEvent", path, "");
			})
			.collect(toList());
	}

}
