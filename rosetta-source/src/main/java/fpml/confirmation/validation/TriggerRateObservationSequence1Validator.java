package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PositiveMoney;
import fpml.confirmation.TriggerRateObservationSequence1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TriggerRateObservationSequence1Validator implements Validator<TriggerRateObservationSequence1> {

	private List<ComparisonResult> getComparisonResults(TriggerRateObservationSequence1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("triggerPrice", (PositiveMoney) o.getTriggerPrice() != null ? 1 : 0, 1, 1), 
				checkCardinality("observedPrice", (PositiveMoney) o.getObservedPrice() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TriggerRateObservationSequence1> validate(RosettaPath path, TriggerRateObservationSequence1 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TriggerRateObservationSequence1", ValidationType.CARDINALITY, "TriggerRateObservationSequence1", path, "", error);
		}
		return success("TriggerRateObservationSequence1", ValidationType.CARDINALITY, "TriggerRateObservationSequence1", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TriggerRateObservationSequence1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TriggerRateObservationSequence1", ValidationType.CARDINALITY, "TriggerRateObservationSequence1", path, "", res.getError());
				}
				return success("TriggerRateObservationSequence1", ValidationType.CARDINALITY, "TriggerRateObservationSequence1", path, "");
			})
			.collect(toList());
	}

}
