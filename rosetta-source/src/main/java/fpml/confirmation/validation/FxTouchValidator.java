package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTouch;
import fpml.confirmation.FxTouchSequence;
import fpml.confirmation.InformationSource;
import fpml.confirmation.QuotedCurrencyPair;
import fpml.confirmation.TouchConditionEnum;
import fpml.confirmation.TriggerConditionEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTouchValidator implements Validator<FxTouch> {

	private List<ComparisonResult> getComparisonResults(FxTouch o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("touchCondition", (TouchConditionEnum) o.getTouchCondition() != null ? 1 : 0, 1, 1), 
				checkCardinality("direction", (TriggerConditionEnum) o.getDirection() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 1, 1), 
				checkCardinality("triggerRate", (BigDecimal) o.getTriggerRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("spotRate", (BigDecimal) o.getSpotRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("informationSource", (List<? extends InformationSource>) o.getInformationSource() == null ? 0 : ((List<? extends InformationSource>) o.getInformationSource()).size(), 1, 0), 
				checkCardinality("fxTouchSequence", (FxTouchSequence) o.getFxTouchSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxTouch> validate(RosettaPath path, FxTouch o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTouch", ValidationType.CARDINALITY, "FxTouch", path, "", error);
		}
		return success("FxTouch", ValidationType.CARDINALITY, "FxTouch", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTouch o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTouch", ValidationType.CARDINALITY, "FxTouch", path, "", res.getError());
				}
				return success("FxTouch", ValidationType.CARDINALITY, "FxTouch", path, "");
			})
			.collect(toList());
	}

}
