package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FloatingLegCalculation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FloatingLegCalculationTypeFormatValidator implements Validator<FloatingLegCalculation> {

	private List<ComparisonResult> getComparisonResults(FloatingLegCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FloatingLegCalculation> validate(RosettaPath path, FloatingLegCalculation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FloatingLegCalculation", ValidationType.TYPE_FORMAT, "FloatingLegCalculation", path, "", error);
		}
		return success("FloatingLegCalculation", ValidationType.TYPE_FORMAT, "FloatingLegCalculation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingLegCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingLegCalculation", ValidationType.TYPE_FORMAT, "FloatingLegCalculation", path, "", res.getError());
				}
				return success("FloatingLegCalculation", ValidationType.TYPE_FORMAT, "FloatingLegCalculation", path, "");
			})
			.collect(toList());
	}

}
