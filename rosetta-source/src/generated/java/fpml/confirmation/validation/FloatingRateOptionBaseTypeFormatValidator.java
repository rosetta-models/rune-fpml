package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FloatingRateOptionBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FloatingRateOptionBaseTypeFormatValidator implements Validator<FloatingRateOptionBase> {

	private List<ComparisonResult> getComparisonResults(FloatingRateOptionBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FloatingRateOptionBase> validate(RosettaPath path, FloatingRateOptionBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FloatingRateOptionBase", ValidationType.TYPE_FORMAT, "FloatingRateOptionBase", path, "", error);
		}
		return success("FloatingRateOptionBase", ValidationType.TYPE_FORMAT, "FloatingRateOptionBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateOptionBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateOptionBase", ValidationType.TYPE_FORMAT, "FloatingRateOptionBase", path, "", res.getError());
				}
				return success("FloatingRateOptionBase", ValidationType.TYPE_FORMAT, "FloatingRateOptionBase", path, "");
			})
			.collect(toList());
	}

}
