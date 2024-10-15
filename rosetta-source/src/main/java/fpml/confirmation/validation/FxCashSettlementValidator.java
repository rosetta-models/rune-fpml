package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.Currency;
import fpml.confirmation.FxCashSettlement;
import fpml.confirmation.PositiveMoney;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxCashSettlementValidator implements Validator<FxCashSettlement> {

	private List<ComparisonResult> getComparisonResults(FxCashSettlement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementCurrency", (Currency) o.getSettlementCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("referenceCurrency", (Currency) o.getReferenceCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmount", (PositiveMoney) o.getNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDate", (AdjustableDate) o.getSettlementDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxCashSettlement> validate(RosettaPath path, FxCashSettlement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxCashSettlement", ValidationType.CARDINALITY, "FxCashSettlement", path, "", error);
		}
		return success("FxCashSettlement", ValidationType.CARDINALITY, "FxCashSettlement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxCashSettlement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxCashSettlement", ValidationType.CARDINALITY, "FxCashSettlement", path, "", res.getError());
				}
				return success("FxCashSettlement", ValidationType.CARDINALITY, "FxCashSettlement", path, "");
			})
			.collect(toList());
	}

}
