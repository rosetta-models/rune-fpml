package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.StubCalculationPeriodAmountSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StubCalculationPeriodAmountSequenceTypeFormatValidator implements Validator<StubCalculationPeriodAmountSequence> {

	private List<ComparisonResult> getComparisonResults(StubCalculationPeriodAmountSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<StubCalculationPeriodAmountSequence> validate(RosettaPath path, StubCalculationPeriodAmountSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("StubCalculationPeriodAmountSequence", ValidationType.TYPE_FORMAT, "StubCalculationPeriodAmountSequence", path, "", error);
		}
		return success("StubCalculationPeriodAmountSequence", ValidationType.TYPE_FORMAT, "StubCalculationPeriodAmountSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StubCalculationPeriodAmountSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StubCalculationPeriodAmountSequence", ValidationType.TYPE_FORMAT, "StubCalculationPeriodAmountSequence", path, "", res.getError());
				}
				return success("StubCalculationPeriodAmountSequence", ValidationType.TYPE_FORMAT, "StubCalculationPeriodAmountSequence", path, "");
			})
			.collect(toList());
	}

}
