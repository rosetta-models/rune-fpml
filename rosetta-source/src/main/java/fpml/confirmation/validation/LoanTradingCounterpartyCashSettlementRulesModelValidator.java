package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuySellEnum;
import fpml.confirmation.LoanTradingAccrualSettlementEnum;
import fpml.confirmation.LoanTradingCounterpartyCashSettlementRulesModel;
import fpml.confirmation.LoanTradingDocTypeEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradingCounterpartyCashSettlementRulesModelValidator implements Validator<LoanTradingCounterpartyCashSettlementRulesModel> {

	private List<ComparisonResult> getComparisonResults(LoanTradingCounterpartyCashSettlementRulesModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("documentationType", (LoanTradingDocTypeEnum) o.getDocumentationType() != null ? 1 : 0, 1, 1), 
				checkCardinality("accrualSettlementType", (LoanTradingAccrualSettlementEnum) o.getAccrualSettlementType() != null ? 1 : 0, 1, 1), 
				checkCardinality("delayedCompensationFlag", (Boolean) o.getDelayedCompensationFlag() != null ? 1 : 0, 1, 1), 
				checkCardinality("nonRecurringFeesBenefactor", (BuySellEnum) o.getNonRecurringFeesBenefactor() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<LoanTradingCounterpartyCashSettlementRulesModel> validate(RosettaPath path, LoanTradingCounterpartyCashSettlementRulesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradingCounterpartyCashSettlementRulesModel", ValidationType.CARDINALITY, "LoanTradingCounterpartyCashSettlementRulesModel", path, "", error);
		}
		return success("LoanTradingCounterpartyCashSettlementRulesModel", ValidationType.CARDINALITY, "LoanTradingCounterpartyCashSettlementRulesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingCounterpartyCashSettlementRulesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingCounterpartyCashSettlementRulesModel", ValidationType.CARDINALITY, "LoanTradingCounterpartyCashSettlementRulesModel", path, "", res.getError());
				}
				return success("LoanTradingCounterpartyCashSettlementRulesModel", ValidationType.CARDINALITY, "LoanTradingCounterpartyCashSettlementRulesModel", path, "");
			})
			.collect(toList());
	}

}
