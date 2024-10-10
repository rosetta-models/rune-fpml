package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EquityMultipleExercise;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquityMultipleExerciseTypeFormatValidator implements Validator<EquityMultipleExercise> {

	private List<ComparisonResult> getComparisonResults(EquityMultipleExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("integralMultipleExercise", o.getIntegralMultipleExercise(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkNumber("minimumNumberOfOptions", o.getMinimumNumberOfOptions(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkNumber("maximumNumberOfOptions", o.getMaximumNumberOfOptions(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<EquityMultipleExercise> validate(RosettaPath path, EquityMultipleExercise o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquityMultipleExercise", ValidationType.TYPE_FORMAT, "EquityMultipleExercise", path, "", error);
		}
		return success("EquityMultipleExercise", ValidationType.TYPE_FORMAT, "EquityMultipleExercise", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityMultipleExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityMultipleExercise", ValidationType.TYPE_FORMAT, "EquityMultipleExercise", path, "", res.getError());
				}
				return success("EquityMultipleExercise", ValidationType.TYPE_FORMAT, "EquityMultipleExercise", path, "");
			})
			.collect(toList());
	}

}
