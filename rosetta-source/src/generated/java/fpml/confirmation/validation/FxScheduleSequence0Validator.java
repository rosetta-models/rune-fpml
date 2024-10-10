package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.FxScheduleSequence0;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxScheduleSequence0Validator implements Validator<FxScheduleSequence0> {

	private List<ComparisonResult> getComparisonResults(FxScheduleSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dateAdjustments", (BusinessDayAdjustments) o.getDateAdjustments() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedDate", (List<Date>) o.getAdjustedDate() == null ? 0 : ((List<Date>) o.getAdjustedDate()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<FxScheduleSequence0> validate(RosettaPath path, FxScheduleSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxScheduleSequence0", ValidationType.CARDINALITY, "FxScheduleSequence0", path, "", error);
		}
		return success("FxScheduleSequence0", ValidationType.CARDINALITY, "FxScheduleSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxScheduleSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxScheduleSequence0", ValidationType.CARDINALITY, "FxScheduleSequence0", path, "", res.getError());
				}
				return success("FxScheduleSequence0", ValidationType.CARDINALITY, "FxScheduleSequence0", path, "");
			})
			.collect(toList());
	}

}
