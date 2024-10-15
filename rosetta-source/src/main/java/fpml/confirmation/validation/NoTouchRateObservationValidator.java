package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NoTouchRateObservation;
import fpml.confirmation.NoTouchRateObservationSequence0;
import fpml.confirmation.NoTouchRateObservationSequence1;
import fpml.confirmation.NoTouchUpperBarrierObservation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NoTouchRateObservationValidator implements Validator<NoTouchRateObservation> {

	private List<ComparisonResult> getComparisonResults(NoTouchRateObservation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("observationStartDate", (Date) o.getObservationStartDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("observationEndDate", (Date) o.getObservationEndDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("noTouchRateObservationSequence0", (NoTouchRateObservationSequence0) o.getNoTouchRateObservationSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("upperBarrier", (NoTouchUpperBarrierObservation) o.getUpperBarrier() != null ? 1 : 0, 0, 1), 
				checkCardinality("noTouchRateObservationSequence1", (NoTouchRateObservationSequence1) o.getNoTouchRateObservationSequence1() != null ? 1 : 0, 0, 1), 
				checkCardinality("isExercisable", (Boolean) o.getIsExercisable() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<NoTouchRateObservation> validate(RosettaPath path, NoTouchRateObservation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NoTouchRateObservation", ValidationType.CARDINALITY, "NoTouchRateObservation", path, "", error);
		}
		return success("NoTouchRateObservation", ValidationType.CARDINALITY, "NoTouchRateObservation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NoTouchRateObservation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NoTouchRateObservation", ValidationType.CARDINALITY, "NoTouchRateObservation", path, "", res.getError());
				}
				return success("NoTouchRateObservation", ValidationType.CARDINALITY, "NoTouchRateObservation", path, "");
			})
			.collect(toList());
	}

}
