package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PremiumQuote;
import fpml.confirmation.PremiumQuoteBasisEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PremiumQuoteValidator implements Validator<PremiumQuote> {

	private List<ComparisonResult> getComparisonResults(PremiumQuote o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (BigDecimal) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("quoteBasis", (PremiumQuoteBasisEnum) o.getQuoteBasis() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<PremiumQuote> validate(RosettaPath path, PremiumQuote o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PremiumQuote", ValidationType.CARDINALITY, "PremiumQuote", path, "", error);
		}
		return success("PremiumQuote", ValidationType.CARDINALITY, "PremiumQuote", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PremiumQuote o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PremiumQuote", ValidationType.CARDINALITY, "PremiumQuote", path, "", res.getError());
				}
				return success("PremiumQuote", ValidationType.CARDINALITY, "PremiumQuote", path, "");
			})
			.collect(toList());
	}

}
