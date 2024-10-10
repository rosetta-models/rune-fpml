package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ObservedRate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ObservedRateTypeFormatValidator implements Validator<ObservedRate> {

	private List<ComparisonResult> getComparisonResults(ObservedRate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ObservedRate> validate(RosettaPath path, ObservedRate o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ObservedRate", ValidationType.TYPE_FORMAT, "ObservedRate", path, "", error);
		}
		return success("ObservedRate", ValidationType.TYPE_FORMAT, "ObservedRate", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObservedRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObservedRate", ValidationType.TYPE_FORMAT, "ObservedRate", path, "", res.getError());
				}
				return success("ObservedRate", ValidationType.TYPE_FORMAT, "ObservedRate", path, "");
			})
			.collect(toList());
	}

}
