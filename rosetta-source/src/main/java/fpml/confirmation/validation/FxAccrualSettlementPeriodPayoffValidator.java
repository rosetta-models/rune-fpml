package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualPayoffRegionReference;
import fpml.confirmation.FxAccrualSettlementPeriodPayoff;
import fpml.confirmation.FxAccrualSettlementPeriodPayoffSequence;
import fpml.confirmation.SettlementPeriodFixingDates;
import fpml.confirmation.SettlementPeriodLeverage;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualSettlementPeriodPayoffValidator implements Validator<FxAccrualSettlementPeriodPayoff> {

	private List<ComparisonResult> getComparisonResults(FxAccrualSettlementPeriodPayoff o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("payoffRegionReference", (FxAccrualPayoffRegionReference) o.getPayoffRegionReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxAccrualSettlementPeriodPayoffSequence", (FxAccrualSettlementPeriodPayoffSequence) o.getFxAccrualSettlementPeriodPayoffSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("averageStrikeFixingDates", (SettlementPeriodFixingDates) o.getAverageStrikeFixingDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("averageRateFixingDates", (SettlementPeriodFixingDates) o.getAverageRateFixingDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("lowerBound", (BigDecimal) o.getLowerBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("upperBound", (BigDecimal) o.getUpperBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("leverage", (SettlementPeriodLeverage) o.getLeverage() != null ? 1 : 0, 0, 1), 
				checkCardinality("payoffCap", (BigDecimal) o.getPayoffCap() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxAccrualSettlementPeriodPayoff> validate(RosettaPath path, FxAccrualSettlementPeriodPayoff o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualSettlementPeriodPayoff", ValidationType.CARDINALITY, "FxAccrualSettlementPeriodPayoff", path, "", error);
		}
		return success("FxAccrualSettlementPeriodPayoff", ValidationType.CARDINALITY, "FxAccrualSettlementPeriodPayoff", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualSettlementPeriodPayoff o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualSettlementPeriodPayoff", ValidationType.CARDINALITY, "FxAccrualSettlementPeriodPayoff", path, "", res.getError());
				}
				return success("FxAccrualSettlementPeriodPayoff", ValidationType.CARDINALITY, "FxAccrualSettlementPeriodPayoff", path, "");
			})
			.collect(toList());
	}

}
