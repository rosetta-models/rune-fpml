package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EquityDerivativeShortFormBase;
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

public class EquityDerivativeShortFormBaseTypeFormatValidator implements Validator<EquityDerivativeShortFormBase> {

	private List<ComparisonResult> getComparisonResults(EquityDerivativeShortFormBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("spotPrice", o.getSpotPrice(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkNumber("numberOfOptions", o.getNumberOfOptions(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<EquityDerivativeShortFormBase> validate(RosettaPath path, EquityDerivativeShortFormBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquityDerivativeShortFormBase", ValidationType.TYPE_FORMAT, "EquityDerivativeShortFormBase", path, "", error);
		}
		return success("EquityDerivativeShortFormBase", ValidationType.TYPE_FORMAT, "EquityDerivativeShortFormBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityDerivativeShortFormBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityDerivativeShortFormBase", ValidationType.TYPE_FORMAT, "EquityDerivativeShortFormBase", path, "", res.getError());
				}
				return success("EquityDerivativeShortFormBase", ValidationType.TYPE_FORMAT, "EquityDerivativeShortFormBase", path, "");
			})
			.collect(toList());
	}

}
