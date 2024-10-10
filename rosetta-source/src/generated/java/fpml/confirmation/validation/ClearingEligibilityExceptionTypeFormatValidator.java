package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ClearingEligibilityException;
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

public class ClearingEligibilityExceptionTypeFormatValidator implements Validator<ClearingEligibilityException> {

	private List<ComparisonResult> getComparisonResults(ClearingEligibilityException o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("expectedBuild", o.getExpectedBuild(), empty(), of(0), of(new BigDecimal("1")), empty()), 
				checkNumber("actualBuild", o.getActualBuild(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public ValidationResult<ClearingEligibilityException> validate(RosettaPath path, ClearingEligibilityException o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ClearingEligibilityException", ValidationType.TYPE_FORMAT, "ClearingEligibilityException", path, "", error);
		}
		return success("ClearingEligibilityException", ValidationType.TYPE_FORMAT, "ClearingEligibilityException", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingEligibilityException o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingEligibilityException", ValidationType.TYPE_FORMAT, "ClearingEligibilityException", path, "", res.getError());
				}
				return success("ClearingEligibilityException", ValidationType.TYPE_FORMAT, "ClearingEligibilityException", path, "");
			})
			.collect(toList());
	}

}
