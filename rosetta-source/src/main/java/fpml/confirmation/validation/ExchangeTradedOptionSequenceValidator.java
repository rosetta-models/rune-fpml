package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Currency;
import fpml.confirmation.ExchangeTradedOptionSequence;
import fpml.confirmation.PriceQuoteUnits;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ExchangeTradedOptionSequenceValidator implements Validator<ExchangeTradedOptionSequence> {

	private List<ComparisonResult> getComparisonResults(ExchangeTradedOptionSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("strike", (BigDecimal) o.getStrike() != null ? 1 : 0, 1, 1), 
				checkCardinality("strikeCurrency", (Currency) o.getStrikeCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikeUnits", (PriceQuoteUnits) o.getStrikeUnits() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ExchangeTradedOptionSequence> validate(RosettaPath path, ExchangeTradedOptionSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ExchangeTradedOptionSequence", ValidationType.CARDINALITY, "ExchangeTradedOptionSequence", path, "", error);
		}
		return success("ExchangeTradedOptionSequence", ValidationType.CARDINALITY, "ExchangeTradedOptionSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExchangeTradedOptionSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExchangeTradedOptionSequence", ValidationType.CARDINALITY, "ExchangeTradedOptionSequence", path, "", res.getError());
				}
				return success("ExchangeTradedOptionSequence", ValidationType.CARDINALITY, "ExchangeTradedOptionSequence", path, "");
			})
			.collect(toList());
	}

}
