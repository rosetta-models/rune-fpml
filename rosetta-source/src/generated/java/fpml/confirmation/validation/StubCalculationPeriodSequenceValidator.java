package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Stub;
import fpml.confirmation.StubCalculationPeriodSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StubCalculationPeriodSequenceValidator implements Validator<StubCalculationPeriodSequence> {

	private List<ComparisonResult> getComparisonResults(StubCalculationPeriodSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("initialStub", (Stub) o.getInitialStub() != null ? 1 : 0, 1, 1), 
				checkCardinality("finalStub", (Stub) o.getFinalStub() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<StubCalculationPeriodSequence> validate(RosettaPath path, StubCalculationPeriodSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("StubCalculationPeriodSequence", ValidationType.CARDINALITY, "StubCalculationPeriodSequence", path, "", error);
		}
		return success("StubCalculationPeriodSequence", ValidationType.CARDINALITY, "StubCalculationPeriodSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StubCalculationPeriodSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StubCalculationPeriodSequence", ValidationType.CARDINALITY, "StubCalculationPeriodSequence", path, "", res.getError());
				}
				return success("StubCalculationPeriodSequence", ValidationType.CARDINALITY, "StubCalculationPeriodSequence", path, "");
			})
			.collect(toList());
	}

}
