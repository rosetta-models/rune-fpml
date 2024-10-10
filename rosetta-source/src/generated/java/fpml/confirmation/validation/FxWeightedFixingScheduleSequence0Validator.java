package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.FxFixingObservation;
import fpml.confirmation.FxWeightedFixingScheduleSequence0;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxWeightedFixingScheduleSequence0Validator implements Validator<FxWeightedFixingScheduleSequence0> {

	private List<ComparisonResult> getComparisonResults(FxWeightedFixingScheduleSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dateAdjustments", (BusinessDayAdjustments) o.getDateAdjustments() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixing", (List<? extends FxFixingObservation>) o.getFixing() == null ? 0 : ((List<? extends FxFixingObservation>) o.getFixing()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<FxWeightedFixingScheduleSequence0> validate(RosettaPath path, FxWeightedFixingScheduleSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxWeightedFixingScheduleSequence0", ValidationType.CARDINALITY, "FxWeightedFixingScheduleSequence0", path, "", error);
		}
		return success("FxWeightedFixingScheduleSequence0", ValidationType.CARDINALITY, "FxWeightedFixingScheduleSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxWeightedFixingScheduleSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxWeightedFixingScheduleSequence0", ValidationType.CARDINALITY, "FxWeightedFixingScheduleSequence0", path, "", res.getError());
				}
				return success("FxWeightedFixingScheduleSequence0", ValidationType.CARDINALITY, "FxWeightedFixingScheduleSequence0", path, "");
			})
			.collect(toList());
	}

}
