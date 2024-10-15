package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Period;
import fpml.confirmation.TimeDimensionSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TimeDimensionSequenceValidator implements Validator<TimeDimensionSequence> {

	private List<ComparisonResult> getComparisonResults(TimeDimensionSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("date", (Date) o.getDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("tenor", (Period) o.getTenor() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TimeDimensionSequence> validate(RosettaPath path, TimeDimensionSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TimeDimensionSequence", ValidationType.CARDINALITY, "TimeDimensionSequence", path, "", error);
		}
		return success("TimeDimensionSequence", ValidationType.CARDINALITY, "TimeDimensionSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TimeDimensionSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TimeDimensionSequence", ValidationType.CARDINALITY, "TimeDimensionSequence", path, "", res.getError());
				}
				return success("TimeDimensionSequence", ValidationType.CARDINALITY, "TimeDimensionSequence", path, "");
			})
			.collect(toList());
	}

}
