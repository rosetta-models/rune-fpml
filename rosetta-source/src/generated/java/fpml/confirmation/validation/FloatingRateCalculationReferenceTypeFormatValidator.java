package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FloatingRateCalculationReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FloatingRateCalculationReferenceTypeFormatValidator implements Validator<FloatingRateCalculationReference> {

	private List<ComparisonResult> getComparisonResults(FloatingRateCalculationReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FloatingRateCalculationReference> validate(RosettaPath path, FloatingRateCalculationReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FloatingRateCalculationReference", ValidationType.TYPE_FORMAT, "FloatingRateCalculationReference", path, "", error);
		}
		return success("FloatingRateCalculationReference", ValidationType.TYPE_FORMAT, "FloatingRateCalculationReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateCalculationReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateCalculationReference", ValidationType.TYPE_FORMAT, "FloatingRateCalculationReference", path, "", res.getError());
				}
				return success("FloatingRateCalculationReference", ValidationType.TYPE_FORMAT, "FloatingRateCalculationReference", path, "");
			})
			.collect(toList());
	}

}
