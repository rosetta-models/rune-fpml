package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CalculationPeriodDatesReference;
import fpml.confirmation.Frequency;
import fpml.confirmation.NotionalStepRule;
import fpml.confirmation.NotionalStepRuleSequence;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NotionalStepRuleValidator implements Validator<NotionalStepRule> {

	private List<ComparisonResult> getComparisonResults(NotionalStepRule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationPeriodDatesReference", (CalculationPeriodDatesReference) o.getCalculationPeriodDatesReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("stepFrequency", (Frequency) o.getStepFrequency() != null ? 1 : 0, 1, 1), 
				checkCardinality("firstNotionalStepDate", (Date) o.getFirstNotionalStepDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("lastNotionalStepDate", (Date) o.getLastNotionalStepDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("notionalStepAmount", (BigDecimal) o.getNotionalStepAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalStepRuleSequence", (NotionalStepRuleSequence) o.getNotionalStepRuleSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<NotionalStepRule> validate(RosettaPath path, NotionalStepRule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NotionalStepRule", ValidationType.CARDINALITY, "NotionalStepRule", path, "", error);
		}
		return success("NotionalStepRule", ValidationType.CARDINALITY, "NotionalStepRule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotionalStepRule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NotionalStepRule", ValidationType.CARDINALITY, "NotionalStepRule", path, "", res.getError());
				}
				return success("NotionalStepRule", ValidationType.CARDINALITY, "NotionalStepRule", path, "");
			})
			.collect(toList());
	}

}
