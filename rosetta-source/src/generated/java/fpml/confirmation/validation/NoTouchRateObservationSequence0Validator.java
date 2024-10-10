package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NoTouchLowerBarrierObservation;
import fpml.confirmation.NoTouchRateObservationSequence0;
import fpml.confirmation.NoTouchUpperBarrierObservation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NoTouchRateObservationSequence0Validator implements Validator<NoTouchRateObservationSequence0> {

	private List<ComparisonResult> getComparisonResults(NoTouchRateObservationSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("lowerBarrier", (NoTouchLowerBarrierObservation) o.getLowerBarrier() != null ? 1 : 0, 1, 1), 
				checkCardinality("upperBarrier", (NoTouchUpperBarrierObservation) o.getUpperBarrier() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<NoTouchRateObservationSequence0> validate(RosettaPath path, NoTouchRateObservationSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NoTouchRateObservationSequence0", ValidationType.CARDINALITY, "NoTouchRateObservationSequence0", path, "", error);
		}
		return success("NoTouchRateObservationSequence0", ValidationType.CARDINALITY, "NoTouchRateObservationSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NoTouchRateObservationSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NoTouchRateObservationSequence0", ValidationType.CARDINALITY, "NoTouchRateObservationSequence0", path, "", res.getError());
				}
				return success("NoTouchRateObservationSequence0", ValidationType.CARDINALITY, "NoTouchRateObservationSequence0", path, "");
			})
			.collect(toList());
	}

}
