package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TermDeposit;
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

public class TermDepositTypeFormatValidator implements Validator<TermDeposit> {

	private List<ComparisonResult> getComparisonResults(TermDeposit o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("fixedRate", o.getFixedRate(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<TermDeposit> validate(RosettaPath path, TermDeposit o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TermDeposit", ValidationType.TYPE_FORMAT, "TermDeposit", path, "", error);
		}
		return success("TermDeposit", ValidationType.TYPE_FORMAT, "TermDeposit", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TermDeposit o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TermDeposit", ValidationType.TYPE_FORMAT, "TermDeposit", path, "", res.getError());
				}
				return success("TermDeposit", ValidationType.TYPE_FORMAT, "TermDeposit", path, "");
			})
			.collect(toList());
	}

}
