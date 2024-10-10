package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CalculationPeriodDatesReference;
import fpml.confirmation.StubCalculationPeriodAmount;
import fpml.confirmation.StubCalculationPeriodAmountSequence;
import fpml.confirmation.StubValue;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StubCalculationPeriodAmountValidator implements Validator<StubCalculationPeriodAmount> {

	private List<ComparisonResult> getComparisonResults(StubCalculationPeriodAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationPeriodDatesReference", (CalculationPeriodDatesReference) o.getCalculationPeriodDatesReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("stubCalculationPeriodAmountSequence", (StubCalculationPeriodAmountSequence) o.getStubCalculationPeriodAmountSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalStub", (StubValue) o.getFinalStub() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<StubCalculationPeriodAmount> validate(RosettaPath path, StubCalculationPeriodAmount o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("StubCalculationPeriodAmount", ValidationType.CARDINALITY, "StubCalculationPeriodAmount", path, "", error);
		}
		return success("StubCalculationPeriodAmount", ValidationType.CARDINALITY, "StubCalculationPeriodAmount", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StubCalculationPeriodAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StubCalculationPeriodAmount", ValidationType.CARDINALITY, "StubCalculationPeriodAmount", path, "", res.getError());
				}
				return success("StubCalculationPeriodAmount", ValidationType.CARDINALITY, "StubCalculationPeriodAmount", path, "");
			})
			.collect(toList());
	}

}
