package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.FxAdjustedDateAndDateAdjustments;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAdjustedDateAndDateAdjustmentsValidator implements Validator<FxAdjustedDateAndDateAdjustments> {

	private List<ComparisonResult> getComparisonResults(FxAdjustedDateAndDateAdjustments o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dateAdjustments", (BusinessDayAdjustments) o.getDateAdjustments() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedDate", (Date) o.getAdjustedDate() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxAdjustedDateAndDateAdjustments> validate(RosettaPath path, FxAdjustedDateAndDateAdjustments o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAdjustedDateAndDateAdjustments", ValidationType.CARDINALITY, "FxAdjustedDateAndDateAdjustments", path, "", error);
		}
		return success("FxAdjustedDateAndDateAdjustments", ValidationType.CARDINALITY, "FxAdjustedDateAndDateAdjustments", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAdjustedDateAndDateAdjustments o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAdjustedDateAndDateAdjustments", ValidationType.CARDINALITY, "FxAdjustedDateAndDateAdjustments", path, "", res.getError());
				}
				return success("FxAdjustedDateAndDateAdjustments", ValidationType.CARDINALITY, "FxAdjustedDateAndDateAdjustments", path, "");
			})
			.collect(toList());
	}

}
