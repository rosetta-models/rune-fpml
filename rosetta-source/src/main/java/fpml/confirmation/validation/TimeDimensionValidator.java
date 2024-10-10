package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Period;
import fpml.confirmation.TimeDimension;
import fpml.confirmation.TimeDimensionSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TimeDimensionValidator implements Validator<TimeDimension> {

	private List<ComparisonResult> getComparisonResults(TimeDimension o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tenor", (Period) o.getTenor() != null ? 1 : 0, 0, 1), 
				checkCardinality("timeDimensionSequence", (TimeDimensionSequence) o.getTimeDimensionSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TimeDimension> validate(RosettaPath path, TimeDimension o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TimeDimension", ValidationType.CARDINALITY, "TimeDimension", path, "", error);
		}
		return success("TimeDimension", ValidationType.CARDINALITY, "TimeDimension", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TimeDimension o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TimeDimension", ValidationType.CARDINALITY, "TimeDimension", path, "", res.getError());
				}
				return success("TimeDimension", ValidationType.CARDINALITY, "TimeDimension", path, "");
			})
			.collect(toList());
	}

}
