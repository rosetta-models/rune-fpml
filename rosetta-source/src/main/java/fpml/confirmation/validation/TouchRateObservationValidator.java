package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.InformationSource;
import fpml.confirmation.TouchRateObservation;
import fpml.confirmation.TouchRateObservationSequence;
import fpml.confirmation.TriggerConditionEnum;
import fpml.confirmation.TriggerRateObservationSequence0;
import fpml.confirmation.TriggerRateObservationSequence1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TouchRateObservationValidator implements Validator<TouchRateObservation> {

	private List<ComparisonResult> getComparisonResults(TouchRateObservation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("observationDate", (Date) o.getObservationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("observationTime", (BusinessCenterTime) o.getObservationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("informationSource", (InformationSource) o.getInformationSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerRateObservationSequence0", (TriggerRateObservationSequence0) o.getTriggerRateObservationSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerRateObservationSequence1", (TriggerRateObservationSequence1) o.getTriggerRateObservationSequence1() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerCondition", (TriggerConditionEnum) o.getTriggerCondition() != null ? 1 : 0, 1, 1), 
				checkCardinality("touchRateObservationSequence", (TouchRateObservationSequence) o.getTouchRateObservationSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("isExercisable", (Boolean) o.getIsExercisable() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TouchRateObservation> validate(RosettaPath path, TouchRateObservation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TouchRateObservation", ValidationType.CARDINALITY, "TouchRateObservation", path, "", error);
		}
		return success("TouchRateObservation", ValidationType.CARDINALITY, "TouchRateObservation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TouchRateObservation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TouchRateObservation", ValidationType.CARDINALITY, "TouchRateObservation", path, "", res.getError());
				}
				return success("TouchRateObservation", ValidationType.CARDINALITY, "TouchRateObservation", path, "");
			})
			.collect(toList());
	}

}
