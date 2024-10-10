package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Currency;
import fpml.confirmation.Money;
import fpml.confirmation.SettlementAmountOrCurrencyModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SettlementAmountOrCurrencyModelValidator implements Validator<SettlementAmountOrCurrencyModel> {

	private List<ComparisonResult> getComparisonResults(SettlementAmountOrCurrencyModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementAmount", (Money) o.getSettlementAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementCurrency", (Currency) o.getSettlementCurrency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<SettlementAmountOrCurrencyModel> validate(RosettaPath path, SettlementAmountOrCurrencyModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SettlementAmountOrCurrencyModel", ValidationType.CARDINALITY, "SettlementAmountOrCurrencyModel", path, "", error);
		}
		return success("SettlementAmountOrCurrencyModel", ValidationType.CARDINALITY, "SettlementAmountOrCurrencyModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SettlementAmountOrCurrencyModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SettlementAmountOrCurrencyModel", ValidationType.CARDINALITY, "SettlementAmountOrCurrencyModel", path, "", res.getError());
				}
				return success("SettlementAmountOrCurrencyModel", ValidationType.CARDINALITY, "SettlementAmountOrCurrencyModel", path, "");
			})
			.collect(toList());
	}

}
