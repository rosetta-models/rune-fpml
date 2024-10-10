package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Currency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CurrencyValidator implements Validator<Currency> {

	private List<ComparisonResult> getComparisonResults(Currency o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("currencyScheme", (String) o.getCurrencyScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Currency> validate(RosettaPath path, Currency o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Currency", ValidationType.CARDINALITY, "Currency", path, "", error);
		}
		return success("Currency", ValidationType.CARDINALITY, "Currency", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Currency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Currency", ValidationType.CARDINALITY, "Currency", path, "", res.getError());
				}
				return success("Currency", ValidationType.CARDINALITY, "Currency", path, "");
			})
			.collect(toList());
	}

}
