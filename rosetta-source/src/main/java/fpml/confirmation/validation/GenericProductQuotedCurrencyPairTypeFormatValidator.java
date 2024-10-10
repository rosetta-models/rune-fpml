package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GenericProductQuotedCurrencyPair;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GenericProductQuotedCurrencyPairTypeFormatValidator implements Validator<GenericProductQuotedCurrencyPair> {

	private List<ComparisonResult> getComparisonResults(GenericProductQuotedCurrencyPair o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<GenericProductQuotedCurrencyPair> validate(RosettaPath path, GenericProductQuotedCurrencyPair o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GenericProductQuotedCurrencyPair", ValidationType.TYPE_FORMAT, "GenericProductQuotedCurrencyPair", path, "", error);
		}
		return success("GenericProductQuotedCurrencyPair", ValidationType.TYPE_FORMAT, "GenericProductQuotedCurrencyPair", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericProductQuotedCurrencyPair o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericProductQuotedCurrencyPair", ValidationType.TYPE_FORMAT, "GenericProductQuotedCurrencyPair", path, "", res.getError());
				}
				return success("GenericProductQuotedCurrencyPair", ValidationType.TYPE_FORMAT, "GenericProductQuotedCurrencyPair", path, "");
			})
			.collect(toList());
	}

}
