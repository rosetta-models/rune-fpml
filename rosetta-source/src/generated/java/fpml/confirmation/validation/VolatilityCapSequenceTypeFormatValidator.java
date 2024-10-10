package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.VolatilityCapSequence;
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

public class VolatilityCapSequenceTypeFormatValidator implements Validator<VolatilityCapSequence> {

	private List<ComparisonResult> getComparisonResults(VolatilityCapSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("volatilityCapFactor", o.getVolatilityCapFactor(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkNumber("totalVolatilityCap", o.getTotalVolatilityCap(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<VolatilityCapSequence> validate(RosettaPath path, VolatilityCapSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VolatilityCapSequence", ValidationType.TYPE_FORMAT, "VolatilityCapSequence", path, "", error);
		}
		return success("VolatilityCapSequence", ValidationType.TYPE_FORMAT, "VolatilityCapSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilityCapSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VolatilityCapSequence", ValidationType.TYPE_FORMAT, "VolatilityCapSequence", path, "", res.getError());
				}
				return success("VolatilityCapSequence", ValidationType.TYPE_FORMAT, "VolatilityCapSequence", path, "");
			})
			.collect(toList());
	}

}
