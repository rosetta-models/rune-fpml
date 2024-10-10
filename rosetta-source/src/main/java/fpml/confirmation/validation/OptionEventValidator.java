package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.KnockOutRateObservation;
import fpml.confirmation.NoTouchRateObservation;
import fpml.confirmation.OptionEvent;
import fpml.confirmation.TouchRateObservation;
import fpml.confirmation.Trade;
import fpml.confirmation.TriggerRateObservation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionEventValidator implements Validator<OptionEvent> {

	private List<ComparisonResult> getComparisonResults(OptionEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("originalTrade", (Trade) o.getOriginalTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("knockIn", (TriggerRateObservation) o.getKnockIn() != null ? 1 : 0, 0, 1), 
				checkCardinality("knockOut", (KnockOutRateObservation) o.getKnockOut() != null ? 1 : 0, 0, 1), 
				checkCardinality("touch", (List<? extends TouchRateObservation>) o.getTouch() == null ? 0 : ((List<? extends TouchRateObservation>) o.getTouch()).size(), 0, 2), 
				checkCardinality("noTouch", (NoTouchRateObservation) o.getNoTouch() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OptionEvent> validate(RosettaPath path, OptionEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionEvent", ValidationType.CARDINALITY, "OptionEvent", path, "", error);
		}
		return success("OptionEvent", ValidationType.CARDINALITY, "OptionEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionEvent", ValidationType.CARDINALITY, "OptionEvent", path, "", res.getError());
				}
				return success("OptionEvent", ValidationType.CARDINALITY, "OptionEvent", path, "");
			})
			.collect(toList());
	}

}
