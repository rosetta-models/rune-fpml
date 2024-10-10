package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Currency;
import fpml.confirmation.FxCashSettlementSimple;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxCashSettlementSimpleValidator implements Validator<FxCashSettlementSimple> {

	private List<ComparisonResult> getComparisonResults(FxCashSettlementSimple o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementCurrency", (Currency) o.getSettlementCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("referenceCurrency", (Currency) o.getReferenceCurrency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxCashSettlementSimple> validate(RosettaPath path, FxCashSettlementSimple o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxCashSettlementSimple", ValidationType.CARDINALITY, "FxCashSettlementSimple", path, "", error);
		}
		return success("FxCashSettlementSimple", ValidationType.CARDINALITY, "FxCashSettlementSimple", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxCashSettlementSimple o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxCashSettlementSimple", ValidationType.CARDINALITY, "FxCashSettlementSimple", path, "", res.getError());
				}
				return success("FxCashSettlementSimple", ValidationType.CARDINALITY, "FxCashSettlementSimple", path, "");
			})
			.collect(toList());
	}

}
