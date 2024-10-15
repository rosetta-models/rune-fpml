package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NoTouchLowerBarrierObservation;
import fpml.confirmation.NoTouchLowerBarrierObservationSequence0;
import fpml.confirmation.NoTouchLowerBarrierObservationSequence1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NoTouchLowerBarrierObservationValidator implements Validator<NoTouchLowerBarrierObservation> {

	private List<ComparisonResult> getComparisonResults(NoTouchLowerBarrierObservation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("noTouchLowerBarrierObservationSequence0", (NoTouchLowerBarrierObservationSequence0) o.getNoTouchLowerBarrierObservationSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("noTouchLowerBarrierObservationSequence1", (NoTouchLowerBarrierObservationSequence1) o.getNoTouchLowerBarrierObservationSequence1() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<NoTouchLowerBarrierObservation> validate(RosettaPath path, NoTouchLowerBarrierObservation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NoTouchLowerBarrierObservation", ValidationType.CARDINALITY, "NoTouchLowerBarrierObservation", path, "", error);
		}
		return success("NoTouchLowerBarrierObservation", ValidationType.CARDINALITY, "NoTouchLowerBarrierObservation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NoTouchLowerBarrierObservation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NoTouchLowerBarrierObservation", ValidationType.CARDINALITY, "NoTouchLowerBarrierObservation", path, "", res.getError());
				}
				return success("NoTouchLowerBarrierObservation", ValidationType.CARDINALITY, "NoTouchLowerBarrierObservation", path, "");
			})
			.collect(toList());
	}

}
