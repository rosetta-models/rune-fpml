package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DividendPeriodPayment;
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

public class DividendPeriodPaymentTypeFormatValidator implements Validator<DividendPeriodPayment> {

	private List<ComparisonResult> getComparisonResults(DividendPeriodPayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("fixedStrike", o.getFixedStrike(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<DividendPeriodPayment> validate(RosettaPath path, DividendPeriodPayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DividendPeriodPayment", ValidationType.TYPE_FORMAT, "DividendPeriodPayment", path, "", error);
		}
		return success("DividendPeriodPayment", ValidationType.TYPE_FORMAT, "DividendPeriodPayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPeriodPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendPeriodPayment", ValidationType.TYPE_FORMAT, "DividendPeriodPayment", path, "", res.getError());
				}
				return success("DividendPeriodPayment", ValidationType.TYPE_FORMAT, "DividendPeriodPayment", path, "");
			})
			.collect(toList());
	}

}
