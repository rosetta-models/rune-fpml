package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ExchangeTradedContractUnderlyer;
import fpml.confirmation.FloatingRateIndexModel;
import fpml.confirmation.QuotedCurrencyPair;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ExchangeTradedContractUnderlyerValidator implements Validator<ExchangeTradedContractUnderlyer> {

	private List<ComparisonResult> getComparisonResults(ExchangeTradedContractUnderlyer o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("floatingRateIndexModel", (FloatingRateIndexModel) o.getFloatingRateIndexModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ExchangeTradedContractUnderlyer> validate(RosettaPath path, ExchangeTradedContractUnderlyer o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ExchangeTradedContractUnderlyer", ValidationType.CARDINALITY, "ExchangeTradedContractUnderlyer", path, "", error);
		}
		return success("ExchangeTradedContractUnderlyer", ValidationType.CARDINALITY, "ExchangeTradedContractUnderlyer", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExchangeTradedContractUnderlyer o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExchangeTradedContractUnderlyer", ValidationType.CARDINALITY, "ExchangeTradedContractUnderlyer", path, "", res.getError());
				}
				return success("ExchangeTradedContractUnderlyer", ValidationType.CARDINALITY, "ExchangeTradedContractUnderlyer", path, "");
			})
			.collect(toList());
	}

}
