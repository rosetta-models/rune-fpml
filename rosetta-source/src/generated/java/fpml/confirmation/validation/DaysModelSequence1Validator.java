package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DayOfWeekEnum;
import fpml.confirmation.DaysModelSequence1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DaysModelSequence1Validator implements Validator<DaysModelSequence1> {

	private List<ComparisonResult> getComparisonResults(DaysModelSequence1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dayOfWeek", (List<DayOfWeekEnum>) o.getDayOfWeek() == null ? 0 : ((List<DayOfWeekEnum>) o.getDayOfWeek()).size(), 1, 7), 
				checkCardinality("dayNumber", (Integer) o.getDayNumber() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<DaysModelSequence1> validate(RosettaPath path, DaysModelSequence1 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DaysModelSequence1", ValidationType.CARDINALITY, "DaysModelSequence1", path, "", error);
		}
		return success("DaysModelSequence1", ValidationType.CARDINALITY, "DaysModelSequence1", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DaysModelSequence1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DaysModelSequence1", ValidationType.CARDINALITY, "DaysModelSequence1", path, "", res.getError());
				}
				return success("DaysModelSequence1", ValidationType.CARDINALITY, "DaysModelSequence1", path, "");
			})
			.collect(toList());
	}

}
