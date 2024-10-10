package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CalculationSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CalculationSequenceTypeFormatValidator implements Validator<CalculationSequence> {

	private List<ComparisonResult> getComparisonResults(CalculationSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CalculationSequence> validate(RosettaPath path, CalculationSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CalculationSequence", ValidationType.TYPE_FORMAT, "CalculationSequence", path, "", error);
		}
		return success("CalculationSequence", ValidationType.TYPE_FORMAT, "CalculationSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationSequence", ValidationType.TYPE_FORMAT, "CalculationSequence", path, "", res.getError());
				}
				return success("CalculationSequence", ValidationType.TYPE_FORMAT, "CalculationSequence", path, "");
			})
			.collect(toList());
	}

}
