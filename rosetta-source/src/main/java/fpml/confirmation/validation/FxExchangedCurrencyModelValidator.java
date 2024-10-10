package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxExchangedCurrency;
import fpml.confirmation.FxExchangedCurrencyModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxExchangedCurrencyModelValidator implements Validator<FxExchangedCurrencyModel> {

	private List<ComparisonResult> getComparisonResults(FxExchangedCurrencyModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("exchangedCurrency1", (FxExchangedCurrency) o.getExchangedCurrency1() != null ? 1 : 0, 1, 1), 
				checkCardinality("exchangedCurrency2", (FxExchangedCurrency) o.getExchangedCurrency2() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxExchangedCurrencyModel> validate(RosettaPath path, FxExchangedCurrencyModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxExchangedCurrencyModel", ValidationType.CARDINALITY, "FxExchangedCurrencyModel", path, "", error);
		}
		return success("FxExchangedCurrencyModel", ValidationType.CARDINALITY, "FxExchangedCurrencyModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxExchangedCurrencyModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxExchangedCurrencyModel", ValidationType.CARDINALITY, "FxExchangedCurrencyModel", path, "", res.getError());
				}
				return success("FxExchangedCurrencyModel", ValidationType.CARDINALITY, "FxExchangedCurrencyModel", path, "");
			})
			.collect(toList());
	}

}
