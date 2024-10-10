package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FloatingAmountCalculation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FloatingAmountCalculationTypeFormatValidator implements Validator<FloatingAmountCalculation> {

	private List<ComparisonResult> getComparisonResults(FloatingAmountCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FloatingAmountCalculation> validate(RosettaPath path, FloatingAmountCalculation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FloatingAmountCalculation", ValidationType.TYPE_FORMAT, "FloatingAmountCalculation", path, "", error);
		}
		return success("FloatingAmountCalculation", ValidationType.TYPE_FORMAT, "FloatingAmountCalculation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingAmountCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingAmountCalculation", ValidationType.TYPE_FORMAT, "FloatingAmountCalculation", path, "", res.getError());
				}
				return success("FloatingAmountCalculation", ValidationType.TYPE_FORMAT, "FloatingAmountCalculation", path, "");
			})
			.collect(toList());
	}

}
