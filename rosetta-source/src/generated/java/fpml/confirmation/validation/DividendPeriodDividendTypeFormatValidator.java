package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DividendPeriodDividend;
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

public class DividendPeriodDividendTypeFormatValidator implements Validator<DividendPeriodDividend> {

	private List<ComparisonResult> getComparisonResults(DividendPeriodDividend o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("multiplier", o.getMultiplier(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<DividendPeriodDividend> validate(RosettaPath path, DividendPeriodDividend o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DividendPeriodDividend", ValidationType.TYPE_FORMAT, "DividendPeriodDividend", path, "", error);
		}
		return success("DividendPeriodDividend", ValidationType.TYPE_FORMAT, "DividendPeriodDividend", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPeriodDividend o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendPeriodDividend", ValidationType.TYPE_FORMAT, "DividendPeriodDividend", path, "", res.getError());
				}
				return success("DividendPeriodDividend", ValidationType.TYPE_FORMAT, "DividendPeriodDividend", path, "");
			})
			.collect(toList());
	}

}
