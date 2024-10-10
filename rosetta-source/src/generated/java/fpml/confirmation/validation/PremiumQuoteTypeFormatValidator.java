package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PremiumQuote;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PremiumQuoteTypeFormatValidator implements Validator<PremiumQuote> {

	private List<ComparisonResult> getComparisonResults(PremiumQuote o) {
		return Lists.<ComparisonResult>newArrayList(
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
			return failure("PremiumQuote", ValidationType.TYPE_FORMAT, "PremiumQuote", path, "", error);
		}
		return success("PremiumQuote", ValidationType.TYPE_FORMAT, "PremiumQuote", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PremiumQuote o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PremiumQuote", ValidationType.TYPE_FORMAT, "PremiumQuote", path, "", res.getError());
				}
				return success("PremiumQuote", ValidationType.TYPE_FORMAT, "PremiumQuote", path, "");
			})
			.collect(toList());
	}

}
