package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InterestCalculationSequence;
import fpml.confirmation.InterpolationMethod;
import fpml.confirmation.InterpolationPeriodEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InterestCalculationSequenceValidator implements Validator<InterestCalculationSequence> {

	private List<ComparisonResult> getComparisonResults(InterestCalculationSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("interpolationMethod", (InterpolationMethod) o.getInterpolationMethod() != null ? 1 : 0, 1, 1), 
				checkCardinality("interpolationPeriod", (InterpolationPeriodEnum) o.getInterpolationPeriod() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<InterestCalculationSequence> validate(RosettaPath path, InterestCalculationSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InterestCalculationSequence", ValidationType.CARDINALITY, "InterestCalculationSequence", path, "", error);
		}
		return success("InterestCalculationSequence", ValidationType.CARDINALITY, "InterestCalculationSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestCalculationSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestCalculationSequence", ValidationType.CARDINALITY, "InterestCalculationSequence", path, "", res.getError());
				}
				return success("InterestCalculationSequence", ValidationType.CARDINALITY, "InterestCalculationSequence", path, "");
			})
			.collect(toList());
	}

}
