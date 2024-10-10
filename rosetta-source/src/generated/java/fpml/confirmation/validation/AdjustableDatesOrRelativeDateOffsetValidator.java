package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.AdjustableDatesOrRelativeDateOffset;
import fpml.confirmation.RelativeDateOffset;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AdjustableDatesOrRelativeDateOffsetValidator implements Validator<AdjustableDatesOrRelativeDateOffset> {

	private List<ComparisonResult> getComparisonResults(AdjustableDatesOrRelativeDateOffset o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("adjustableDates", (AdjustableDates) o.getAdjustableDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativeDate", (RelativeDateOffset) o.getRelativeDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<AdjustableDatesOrRelativeDateOffset> validate(RosettaPath path, AdjustableDatesOrRelativeDateOffset o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AdjustableDatesOrRelativeDateOffset", ValidationType.CARDINALITY, "AdjustableDatesOrRelativeDateOffset", path, "", error);
		}
		return success("AdjustableDatesOrRelativeDateOffset", ValidationType.CARDINALITY, "AdjustableDatesOrRelativeDateOffset", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableDatesOrRelativeDateOffset o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdjustableDatesOrRelativeDateOffset", ValidationType.CARDINALITY, "AdjustableDatesOrRelativeDateOffset", path, "", res.getError());
				}
				return success("AdjustableDatesOrRelativeDateOffset", ValidationType.CARDINALITY, "AdjustableDatesOrRelativeDateOffset", path, "");
			})
			.collect(toList());
	}

}
