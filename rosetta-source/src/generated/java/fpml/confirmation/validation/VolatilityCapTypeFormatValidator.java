package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.VolatilityCap;
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

public class VolatilityCapTypeFormatValidator implements Validator<VolatilityCap> {

	private List<ComparisonResult> getComparisonResults(VolatilityCap o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("totalVolatilityCap", o.getTotalVolatilityCap(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<VolatilityCap> validate(RosettaPath path, VolatilityCap o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VolatilityCap", ValidationType.TYPE_FORMAT, "VolatilityCap", path, "", error);
		}
		return success("VolatilityCap", ValidationType.TYPE_FORMAT, "VolatilityCap", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilityCap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VolatilityCap", ValidationType.TYPE_FORMAT, "VolatilityCap", path, "", res.getError());
				}
				return success("VolatilityCap", ValidationType.TYPE_FORMAT, "VolatilityCap", path, "");
			})
			.collect(toList());
	}

}
