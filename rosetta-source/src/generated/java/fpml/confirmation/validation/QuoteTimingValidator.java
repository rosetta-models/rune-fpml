package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.QuoteTiming;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class QuoteTimingValidator implements Validator<QuoteTiming> {

	private List<ComparisonResult> getComparisonResults(QuoteTiming o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("quoteTimingScheme", (String) o.getQuoteTimingScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<QuoteTiming> validate(RosettaPath path, QuoteTiming o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("QuoteTiming", ValidationType.CARDINALITY, "QuoteTiming", path, "", error);
		}
		return success("QuoteTiming", ValidationType.CARDINALITY, "QuoteTiming", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, QuoteTiming o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("QuoteTiming", ValidationType.CARDINALITY, "QuoteTiming", path, "", res.getError());
				}
				return success("QuoteTiming", ValidationType.CARDINALITY, "QuoteTiming", path, "");
			})
			.collect(toList());
	}

}
