package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates2;
import fpml.confirmation.PeriodicDates;
import fpml.confirmation.RelativeDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AdjustableRelativeOrPeriodicDates2Validator implements Validator<AdjustableRelativeOrPeriodicDates2> {

	private List<ComparisonResult> getComparisonResults(AdjustableRelativeOrPeriodicDates2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("adjustableDates", (AdjustableDates) o.getAdjustableDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativeDates", (RelativeDates) o.getRelativeDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("periodicDates", (PeriodicDates) o.getPeriodicDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<AdjustableRelativeOrPeriodicDates2> validate(RosettaPath path, AdjustableRelativeOrPeriodicDates2 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AdjustableRelativeOrPeriodicDates2", ValidationType.CARDINALITY, "AdjustableRelativeOrPeriodicDates2", path, "", error);
		}
		return success("AdjustableRelativeOrPeriodicDates2", ValidationType.CARDINALITY, "AdjustableRelativeOrPeriodicDates2", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableRelativeOrPeriodicDates2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdjustableRelativeOrPeriodicDates2", ValidationType.CARDINALITY, "AdjustableRelativeOrPeriodicDates2", path, "", res.getError());
				}
				return success("AdjustableRelativeOrPeriodicDates2", ValidationType.CARDINALITY, "AdjustableRelativeOrPeriodicDates2", path, "");
			})
			.collect(toList());
	}

}
