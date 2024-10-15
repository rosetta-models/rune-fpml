package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxCounterCurrencyAmount;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxCounterCurrencyAmountTypeFormatValidator implements Validator<FxCounterCurrencyAmount> {

	private List<ComparisonResult> getComparisonResults(FxCounterCurrencyAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("initialValue", o.getInitialValue(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<FxCounterCurrencyAmount> validate(RosettaPath path, FxCounterCurrencyAmount o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxCounterCurrencyAmount", ValidationType.TYPE_FORMAT, "FxCounterCurrencyAmount", path, "", error);
		}
		return success("FxCounterCurrencyAmount", ValidationType.TYPE_FORMAT, "FxCounterCurrencyAmount", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxCounterCurrencyAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxCounterCurrencyAmount", ValidationType.TYPE_FORMAT, "FxCounterCurrencyAmount", path, "", res.getError());
				}
				return success("FxCounterCurrencyAmount", ValidationType.TYPE_FORMAT, "FxCounterCurrencyAmount", path, "");
			})
			.collect(toList());
	}

}
