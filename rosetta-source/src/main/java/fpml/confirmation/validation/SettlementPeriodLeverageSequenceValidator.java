package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SettlementPeriodLeverageSequence;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementPeriodLeverageSequenceValidator implements Validator<SettlementPeriodLeverageSequence> {

	private List<ComparisonResult> getComparisonResults(SettlementPeriodLeverageSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("notionalAmount", (BigDecimal) o.getNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("counterCurrencyAmount", (BigDecimal) o.getCounterCurrencyAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<SettlementPeriodLeverageSequence> validate(RosettaPath path, SettlementPeriodLeverageSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementPeriodLeverageSequence", ValidationType.CARDINALITY, "SettlementPeriodLeverageSequence", path, "", error);
		}
		return success("SettlementPeriodLeverageSequence", ValidationType.CARDINALITY, "SettlementPeriodLeverageSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementPeriodLeverageSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementPeriodLeverageSequence", ValidationType.CARDINALITY, "SettlementPeriodLeverageSequence", path, "", res.getError());
				}
				return success("SettlementPeriodLeverageSequence", ValidationType.CARDINALITY, "SettlementPeriodLeverageSequence", path, "");
			})
			.collect(toList());
	}

}
