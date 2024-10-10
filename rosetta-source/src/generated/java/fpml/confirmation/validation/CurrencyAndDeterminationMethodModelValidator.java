package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CurrencyAndDeterminationMethodModel;
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.IdentifiedCurrencyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CurrencyAndDeterminationMethodModelValidator implements Validator<CurrencyAndDeterminationMethodModel> {

	private List<ComparisonResult> getComparisonResults(CurrencyAndDeterminationMethodModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("currency", (IdentifiedCurrency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("determinationMethod", (DeterminationMethod) o.getDeterminationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("currencyReference", (IdentifiedCurrencyReference) o.getCurrencyReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CurrencyAndDeterminationMethodModel> validate(RosettaPath path, CurrencyAndDeterminationMethodModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CurrencyAndDeterminationMethodModel", ValidationType.CARDINALITY, "CurrencyAndDeterminationMethodModel", path, "", error);
		}
		return success("CurrencyAndDeterminationMethodModel", ValidationType.CARDINALITY, "CurrencyAndDeterminationMethodModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CurrencyAndDeterminationMethodModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CurrencyAndDeterminationMethodModel", ValidationType.CARDINALITY, "CurrencyAndDeterminationMethodModel", path, "", res.getError());
				}
				return success("CurrencyAndDeterminationMethodModel", ValidationType.CARDINALITY, "CurrencyAndDeterminationMethodModel", path, "");
			})
			.collect(toList());
	}

}
