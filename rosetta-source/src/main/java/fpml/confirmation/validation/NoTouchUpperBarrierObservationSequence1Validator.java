package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NoTouchUpperBarrierObservationSequence1;
import fpml.confirmation.ObservedPrice;
import fpml.confirmation.PositiveMoney;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NoTouchUpperBarrierObservationSequence1Validator implements Validator<NoTouchUpperBarrierObservationSequence1> {

	private List<ComparisonResult> getComparisonResults(NoTouchUpperBarrierObservationSequence1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("triggerPrice", (PositiveMoney) o.getTriggerPrice() != null ? 1 : 0, 1, 1), 
				checkCardinality("maximumObservedPrice", (ObservedPrice) o.getMaximumObservedPrice() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<NoTouchUpperBarrierObservationSequence1> validate(RosettaPath path, NoTouchUpperBarrierObservationSequence1 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NoTouchUpperBarrierObservationSequence1", ValidationType.CARDINALITY, "NoTouchUpperBarrierObservationSequence1", path, "", error);
		}
		return success("NoTouchUpperBarrierObservationSequence1", ValidationType.CARDINALITY, "NoTouchUpperBarrierObservationSequence1", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NoTouchUpperBarrierObservationSequence1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NoTouchUpperBarrierObservationSequence1", ValidationType.CARDINALITY, "NoTouchUpperBarrierObservationSequence1", path, "", res.getError());
				}
				return success("NoTouchUpperBarrierObservationSequence1", ValidationType.CARDINALITY, "NoTouchUpperBarrierObservationSequence1", path, "");
			})
			.collect(toList());
	}

}
