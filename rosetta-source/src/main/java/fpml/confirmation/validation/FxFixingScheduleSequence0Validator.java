package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.FxFixingScheduleSequence0;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxFixingScheduleSequence0Validator implements Validator<FxFixingScheduleSequence0> {

	private List<ComparisonResult> getComparisonResults(FxFixingScheduleSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dateAdjustments", (BusinessDayAdjustments) o.getDateAdjustments() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingDate", (List<Date>) o.getFixingDate() == null ? 0 : ((List<Date>) o.getFixingDate()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<FxFixingScheduleSequence0> validate(RosettaPath path, FxFixingScheduleSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxFixingScheduleSequence0", ValidationType.CARDINALITY, "FxFixingScheduleSequence0", path, "", error);
		}
		return success("FxFixingScheduleSequence0", ValidationType.CARDINALITY, "FxFixingScheduleSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFixingScheduleSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxFixingScheduleSequence0", ValidationType.CARDINALITY, "FxFixingScheduleSequence0", path, "", res.getError());
				}
				return success("FxFixingScheduleSequence0", ValidationType.CARDINALITY, "FxFixingScheduleSequence0", path, "");
			})
			.collect(toList());
	}

}
