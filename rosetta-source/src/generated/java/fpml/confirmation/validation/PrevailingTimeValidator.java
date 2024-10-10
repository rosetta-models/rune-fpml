package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PrevailingTime;
import fpml.confirmation.TimezoneLocation;
import java.time.LocalTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PrevailingTimeValidator implements Validator<PrevailingTime> {

	private List<ComparisonResult> getComparisonResults(PrevailingTime o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("hourMinuteTime", (LocalTime) o.getHourMinuteTime() != null ? 1 : 0, 1, 1), 
				checkCardinality("location", (TimezoneLocation) o.getLocation() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<PrevailingTime> validate(RosettaPath path, PrevailingTime o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PrevailingTime", ValidationType.CARDINALITY, "PrevailingTime", path, "", error);
		}
		return success("PrevailingTime", ValidationType.CARDINALITY, "PrevailingTime", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrevailingTime o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrevailingTime", ValidationType.CARDINALITY, "PrevailingTime", path, "", res.getError());
				}
				return success("PrevailingTime", ValidationType.CARDINALITY, "PrevailingTime", path, "");
			})
			.collect(toList());
	}

}
