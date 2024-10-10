package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DayCountFraction;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DayCountFractionValidator implements Validator<DayCountFraction> {

	private List<ComparisonResult> getComparisonResults(DayCountFraction o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("dayCountFractionScheme", (String) o.getDayCountFractionScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<DayCountFraction> validate(RosettaPath path, DayCountFraction o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DayCountFraction", ValidationType.CARDINALITY, "DayCountFraction", path, "", error);
		}
		return success("DayCountFraction", ValidationType.CARDINALITY, "DayCountFraction", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DayCountFraction o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DayCountFraction", ValidationType.CARDINALITY, "DayCountFraction", path, "", res.getError());
				}
				return success("DayCountFraction", ValidationType.CARDINALITY, "DayCountFraction", path, "");
			})
			.collect(toList());
	}

}
