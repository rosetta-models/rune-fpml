package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTargetSettlementPeriod;
import fpml.confirmation.FxTargetSettlementPeriodPayoff;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetSettlementPeriodValidator implements Validator<FxTargetSettlementPeriod> {

	private List<ComparisonResult> getComparisonResults(FxTargetSettlementPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expiryDate", (Date) o.getExpiryDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementDate", (Date) o.getSettlementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("notionalAmount", (BigDecimal) o.getNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("pivot", (BigDecimal) o.getPivot() != null ? 1 : 0, 0, 1), 
				checkCardinality("payoff", (List<? extends FxTargetSettlementPeriodPayoff>) o.getPayoff() == null ? 0 : ((List<? extends FxTargetSettlementPeriodPayoff>) o.getPayoff()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<FxTargetSettlementPeriod> validate(RosettaPath path, FxTargetSettlementPeriod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetSettlementPeriod", ValidationType.CARDINALITY, "FxTargetSettlementPeriod", path, "", error);
		}
		return success("FxTargetSettlementPeriod", ValidationType.CARDINALITY, "FxTargetSettlementPeriod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetSettlementPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetSettlementPeriod", ValidationType.CARDINALITY, "FxTargetSettlementPeriod", path, "", res.getError());
				}
				return success("FxTargetSettlementPeriod", ValidationType.CARDINALITY, "FxTargetSettlementPeriod", path, "");
			})
			.collect(toList());
	}

}
