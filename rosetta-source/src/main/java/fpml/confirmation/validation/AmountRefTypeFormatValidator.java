package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AmountRef;
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

public class AmountRefTypeFormatValidator implements Validator<AmountRef> {

	private List<ComparisonResult> getComparisonResults(AmountRef o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("amount", o.getAmount(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<AmountRef> validate(RosettaPath path, AmountRef o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AmountRef", ValidationType.TYPE_FORMAT, "AmountRef", path, "", error);
		}
		return success("AmountRef", ValidationType.TYPE_FORMAT, "AmountRef", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AmountRef o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AmountRef", ValidationType.TYPE_FORMAT, "AmountRef", path, "", res.getError());
				}
				return success("AmountRef", ValidationType.TYPE_FORMAT, "AmountRef", path, "");
			})
			.collect(toList());
	}

}
