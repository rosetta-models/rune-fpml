package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TimezoneLocation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TimezoneLocationValidator implements Validator<TimezoneLocation> {

	private List<ComparisonResult> getComparisonResults(TimezoneLocation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("timezoneLocationScheme", (String) o.getTimezoneLocationScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TimezoneLocation> validate(RosettaPath path, TimezoneLocation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TimezoneLocation", ValidationType.CARDINALITY, "TimezoneLocation", path, "", error);
		}
		return success("TimezoneLocation", ValidationType.CARDINALITY, "TimezoneLocation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TimezoneLocation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TimezoneLocation", ValidationType.CARDINALITY, "TimezoneLocation", path, "", res.getError());
				}
				return success("TimezoneLocation", ValidationType.CARDINALITY, "TimezoneLocation", path, "");
			})
			.collect(toList());
	}

}
