package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FloatingRateAccrualSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FloatingRateAccrualSequenceTypeFormatValidator implements Validator<FloatingRateAccrualSequence> {

	private List<ComparisonResult> getComparisonResults(FloatingRateAccrualSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FloatingRateAccrualSequence> validate(RosettaPath path, FloatingRateAccrualSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FloatingRateAccrualSequence", ValidationType.TYPE_FORMAT, "FloatingRateAccrualSequence", path, "", error);
		}
		return success("FloatingRateAccrualSequence", ValidationType.TYPE_FORMAT, "FloatingRateAccrualSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateAccrualSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateAccrualSequence", ValidationType.TYPE_FORMAT, "FloatingRateAccrualSequence", path, "", res.getError());
				}
				return success("FloatingRateAccrualSequence", ValidationType.TYPE_FORMAT, "FloatingRateAccrualSequence", path, "");
			})
			.collect(toList());
	}

}
