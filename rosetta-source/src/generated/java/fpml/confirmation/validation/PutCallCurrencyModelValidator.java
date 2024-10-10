package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Currency;
import fpml.confirmation.PutCallCurrencyModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PutCallCurrencyModelValidator implements Validator<PutCallCurrencyModel> {

	private List<ComparisonResult> getComparisonResults(PutCallCurrencyModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("putCurrency", (Currency) o.getPutCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("callCurrency", (Currency) o.getCallCurrency() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<PutCallCurrencyModel> validate(RosettaPath path, PutCallCurrencyModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PutCallCurrencyModel", ValidationType.CARDINALITY, "PutCallCurrencyModel", path, "", error);
		}
		return success("PutCallCurrencyModel", ValidationType.CARDINALITY, "PutCallCurrencyModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PutCallCurrencyModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PutCallCurrencyModel", ValidationType.CARDINALITY, "PutCallCurrencyModel", path, "", res.getError());
				}
				return success("PutCallCurrencyModel", ValidationType.CARDINALITY, "PutCallCurrencyModel", path, "");
			})
			.collect(toList());
	}

}
