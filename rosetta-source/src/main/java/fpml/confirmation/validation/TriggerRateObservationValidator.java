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
import fpml.confirmation.TriggerConditionEnum;
import fpml.confirmation.TriggerRateObservation;
import fpml.confirmation.TriggerRateObservationSequence0;
import fpml.confirmation.TriggerRateObservationSequence1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TriggerRateObservationValidator implements Validator<TriggerRateObservation> {

	private List<ComparisonResult> getComparisonResults(TriggerRateObservation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("observationDate", (Date) o.getObservationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("observationTime", (BusinessCenterTime) o.getObservationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("informationSource", (InformationSource) o.getInformationSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerRateObservationSequence0", (TriggerRateObservationSequence0) o.getTriggerRateObservationSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerRateObservationSequence1", (TriggerRateObservationSequence1) o.getTriggerRateObservationSequence1() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerCondition", (TriggerConditionEnum) o.getTriggerCondition() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<TriggerRateObservation> validate(RosettaPath path, TriggerRateObservation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TriggerRateObservation", ValidationType.CARDINALITY, "TriggerRateObservation", path, "", error);
		}
		return success("TriggerRateObservation", ValidationType.CARDINALITY, "TriggerRateObservation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TriggerRateObservation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TriggerRateObservation", ValidationType.CARDINALITY, "TriggerRateObservation", path, "", res.getError());
				}
				return success("TriggerRateObservation", ValidationType.CARDINALITY, "TriggerRateObservation", path, "");
			})
			.collect(toList());
	}

}
