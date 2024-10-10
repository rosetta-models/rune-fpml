package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NoTouchUpperBarrierObservationSequence0;
import fpml.confirmation.ObservedRate;
import fpml.confirmation.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NoTouchUpperBarrierObservationSequence0Validator implements Validator<NoTouchUpperBarrierObservationSequence0> {

	private List<ComparisonResult> getComparisonResults(NoTouchUpperBarrierObservationSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("triggerRate", (BigDecimal) o.getTriggerRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 1, 1), 
				checkCardinality("maximumObservedRate", (ObservedRate) o.getMaximumObservedRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<NoTouchUpperBarrierObservationSequence0> validate(RosettaPath path, NoTouchUpperBarrierObservationSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NoTouchUpperBarrierObservationSequence0", ValidationType.CARDINALITY, "NoTouchUpperBarrierObservationSequence0", path, "", error);
		}
		return success("NoTouchUpperBarrierObservationSequence0", ValidationType.CARDINALITY, "NoTouchUpperBarrierObservationSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NoTouchUpperBarrierObservationSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NoTouchUpperBarrierObservationSequence0", ValidationType.CARDINALITY, "NoTouchUpperBarrierObservationSequence0", path, "", res.getError());
				}
				return success("NoTouchUpperBarrierObservationSequence0", ValidationType.CARDINALITY, "NoTouchUpperBarrierObservationSequence0", path, "");
			})
			.collect(toList());
	}

}
