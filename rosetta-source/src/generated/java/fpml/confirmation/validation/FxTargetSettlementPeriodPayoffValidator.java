package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTargetPayoffRegionReference;
import fpml.confirmation.FxTargetSettlementPeriodPayoff;
import fpml.confirmation.SettlementPeriodLeverage;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetSettlementPeriodPayoffValidator implements Validator<FxTargetSettlementPeriodPayoff> {

	private List<ComparisonResult> getComparisonResults(FxTargetSettlementPeriodPayoff o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("payoffRegionReference", (FxTargetPayoffRegionReference) o.getPayoffRegionReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("strike", (BigDecimal) o.getStrike() != null ? 1 : 0, 1, 1), 
				checkCardinality("counterCurrencyAmount", (BigDecimal) o.getCounterCurrencyAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("lowerBound", (BigDecimal) o.getLowerBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("upperBound", (BigDecimal) o.getUpperBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("leverage", (SettlementPeriodLeverage) o.getLeverage() != null ? 1 : 0, 0, 1), 
				checkCardinality("payoffCap", (BigDecimal) o.getPayoffCap() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxTargetSettlementPeriodPayoff> validate(RosettaPath path, FxTargetSettlementPeriodPayoff o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetSettlementPeriodPayoff", ValidationType.CARDINALITY, "FxTargetSettlementPeriodPayoff", path, "", error);
		}
		return success("FxTargetSettlementPeriodPayoff", ValidationType.CARDINALITY, "FxTargetSettlementPeriodPayoff", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetSettlementPeriodPayoff o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetSettlementPeriodPayoff", ValidationType.CARDINALITY, "FxTargetSettlementPeriodPayoff", path, "", res.getError());
				}
				return success("FxTargetSettlementPeriodPayoff", ValidationType.CARDINALITY, "FxTargetSettlementPeriodPayoff", path, "");
			})
			.collect(toList());
	}

}
