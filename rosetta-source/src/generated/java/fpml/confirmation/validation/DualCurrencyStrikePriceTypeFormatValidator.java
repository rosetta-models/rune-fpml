package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DualCurrencyStrikePrice;
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

public class DualCurrencyStrikePriceTypeFormatValidator implements Validator<DualCurrencyStrikePrice> {

	private List<ComparisonResult> getComparisonResults(DualCurrencyStrikePrice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("rate", o.getRate(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<DualCurrencyStrikePrice> validate(RosettaPath path, DualCurrencyStrikePrice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DualCurrencyStrikePrice", ValidationType.TYPE_FORMAT, "DualCurrencyStrikePrice", path, "", error);
		}
		return success("DualCurrencyStrikePrice", ValidationType.TYPE_FORMAT, "DualCurrencyStrikePrice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DualCurrencyStrikePrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DualCurrencyStrikePrice", ValidationType.TYPE_FORMAT, "DualCurrencyStrikePrice", path, "", res.getError());
				}
				return success("DualCurrencyStrikePrice", ValidationType.TYPE_FORMAT, "DualCurrencyStrikePrice", path, "");
			})
			.collect(toList());
	}

}
