package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FloatingRateAccrualSequenceSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FloatingRateAccrualSequenceSequenceTypeFormatValidator implements Validator<FloatingRateAccrualSequenceSequence> {

	private List<ComparisonResult> getComparisonResults(FloatingRateAccrualSequenceSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FloatingRateAccrualSequenceSequence> validate(RosettaPath path, FloatingRateAccrualSequenceSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FloatingRateAccrualSequenceSequence", ValidationType.TYPE_FORMAT, "FloatingRateAccrualSequenceSequence", path, "", error);
		}
		return success("FloatingRateAccrualSequenceSequence", ValidationType.TYPE_FORMAT, "FloatingRateAccrualSequenceSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateAccrualSequenceSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateAccrualSequenceSequence", ValidationType.TYPE_FORMAT, "FloatingRateAccrualSequenceSequence", path, "", res.getError());
				}
				return success("FloatingRateAccrualSequenceSequence", ValidationType.TYPE_FORMAT, "FloatingRateAccrualSequenceSequence", path, "");
			})
			.collect(toList());
	}

}
