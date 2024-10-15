package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GenericProductExchangeRate;
import fpml.confirmation.GenericProductExchangeRateSequence;
import fpml.confirmation.GenericProductQuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GenericProductExchangeRateValidator implements Validator<GenericProductExchangeRate> {

	private List<ComparisonResult> getComparisonResults(GenericProductExchangeRate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("quotedCurrencyPair", (GenericProductQuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 1, 1), 
				checkCardinality("rate", (BigDecimal) o.getRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("genericProductExchangeRateSequence", (GenericProductExchangeRateSequence) o.getGenericProductExchangeRateSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<GenericProductExchangeRate> validate(RosettaPath path, GenericProductExchangeRate o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GenericProductExchangeRate", ValidationType.CARDINALITY, "GenericProductExchangeRate", path, "", error);
		}
		return success("GenericProductExchangeRate", ValidationType.CARDINALITY, "GenericProductExchangeRate", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericProductExchangeRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericProductExchangeRate", ValidationType.CARDINALITY, "GenericProductExchangeRate", path, "", res.getError());
				}
				return success("GenericProductExchangeRate", ValidationType.CARDINALITY, "GenericProductExchangeRate", path, "");
			})
			.collect(toList());
	}

}
