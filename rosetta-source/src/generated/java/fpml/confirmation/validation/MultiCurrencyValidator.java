package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Currency;
import fpml.confirmation.MultiCurrency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MultiCurrencyValidator implements Validator<MultiCurrency> {

	private List<ComparisonResult> getComparisonResults(MultiCurrency o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("drawCurrency", (List<? extends Currency>) o.getDrawCurrency() == null ? 0 : ((List<? extends Currency>) o.getDrawCurrency()).size(), 2, 0)
			);
	}

	@Override
	public ValidationResult<MultiCurrency> validate(RosettaPath path, MultiCurrency o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MultiCurrency", ValidationType.CARDINALITY, "MultiCurrency", path, "", error);
		}
		return success("MultiCurrency", ValidationType.CARDINALITY, "MultiCurrency", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MultiCurrency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MultiCurrency", ValidationType.CARDINALITY, "MultiCurrency", path, "", res.getError());
				}
				return success("MultiCurrency", ValidationType.CARDINALITY, "MultiCurrency", path, "");
			})
			.collect(toList());
	}

}
