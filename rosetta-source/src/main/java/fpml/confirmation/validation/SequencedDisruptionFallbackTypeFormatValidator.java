package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SequencedDisruptionFallback;
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

public class SequencedDisruptionFallbackTypeFormatValidator implements Validator<SequencedDisruptionFallback> {

	private List<ComparisonResult> getComparisonResults(SequencedDisruptionFallback o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("sequence", o.getSequence(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public ValidationResult<SequencedDisruptionFallback> validate(RosettaPath path, SequencedDisruptionFallback o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SequencedDisruptionFallback", ValidationType.TYPE_FORMAT, "SequencedDisruptionFallback", path, "", error);
		}
		return success("SequencedDisruptionFallback", ValidationType.TYPE_FORMAT, "SequencedDisruptionFallback", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SequencedDisruptionFallback o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SequencedDisruptionFallback", ValidationType.TYPE_FORMAT, "SequencedDisruptionFallback", path, "", res.getError());
				}
				return success("SequencedDisruptionFallback", ValidationType.TYPE_FORMAT, "SequencedDisruptionFallback", path, "");
			})
			.collect(toList());
	}

}
