package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FirstPeriodStartDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FirstPeriodStartDateValidator implements Validator<FirstPeriodStartDate> {

	private List<ComparisonResult> getComparisonResults(FirstPeriodStartDate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (Date) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("href", (String) o.getHref() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FirstPeriodStartDate> validate(RosettaPath path, FirstPeriodStartDate o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FirstPeriodStartDate", ValidationType.CARDINALITY, "FirstPeriodStartDate", path, "", error);
		}
		return success("FirstPeriodStartDate", ValidationType.CARDINALITY, "FirstPeriodStartDate", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FirstPeriodStartDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FirstPeriodStartDate", ValidationType.CARDINALITY, "FirstPeriodStartDate", path, "", res.getError());
				}
				return success("FirstPeriodStartDate", ValidationType.CARDINALITY, "FirstPeriodStartDate", path, "");
			})
			.collect(toList());
	}

}
