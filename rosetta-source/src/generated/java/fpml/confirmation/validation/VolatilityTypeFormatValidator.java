package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Volatility;
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

public class VolatilityTypeFormatValidator implements Validator<Volatility> {

	private List<ComparisonResult> getComparisonResults(Volatility o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("expectedN", o.getExpectedN(), empty(), of(0), of(new BigDecimal("1")), empty()), 
				checkNumber("volatilityStrikePrice", o.getVolatilityStrikePrice(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<Volatility> validate(RosettaPath path, Volatility o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Volatility", ValidationType.TYPE_FORMAT, "Volatility", path, "", error);
		}
		return success("Volatility", ValidationType.TYPE_FORMAT, "Volatility", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Volatility o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Volatility", ValidationType.TYPE_FORMAT, "Volatility", path, "", res.getError());
				}
				return success("Volatility", ValidationType.TYPE_FORMAT, "Volatility", path, "");
			})
			.collect(toList());
	}

}
