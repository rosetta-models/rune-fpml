package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTriggerBase;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.TriggerConditionEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTriggerBaseValidator implements Validator<FxTriggerBase> {

	private List<ComparisonResult> getComparisonResults(FxTriggerBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("triggerCondition", (TriggerConditionEnum) o.getTriggerCondition() != null ? 1 : 0, 1, 1), 
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 1, 1), 
				checkCardinality("triggerRate", (BigDecimal) o.getTriggerRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("spotRate", (BigDecimal) o.getSpotRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxTriggerBase> validate(RosettaPath path, FxTriggerBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTriggerBase", ValidationType.CARDINALITY, "FxTriggerBase", path, "", error);
		}
		return success("FxTriggerBase", ValidationType.CARDINALITY, "FxTriggerBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTriggerBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTriggerBase", ValidationType.CARDINALITY, "FxTriggerBase", path, "", res.getError());
				}
				return success("FxTriggerBase", ValidationType.CARDINALITY, "FxTriggerBase", path, "");
			})
			.collect(toList());
	}

}
