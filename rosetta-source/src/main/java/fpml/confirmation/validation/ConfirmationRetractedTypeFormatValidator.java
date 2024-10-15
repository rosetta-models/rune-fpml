package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ConfirmationRetracted;
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

public class ConfirmationRetractedTypeFormatValidator implements Validator<ConfirmationRetracted> {

	private List<ComparisonResult> getComparisonResults(ConfirmationRetracted o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("expectedBuild", o.getExpectedBuild(), empty(), of(0), of(new BigDecimal("1")), empty()), 
				checkNumber("actualBuild", o.getActualBuild(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public ValidationResult<ConfirmationRetracted> validate(RosettaPath path, ConfirmationRetracted o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ConfirmationRetracted", ValidationType.TYPE_FORMAT, "ConfirmationRetracted", path, "", error);
		}
		return success("ConfirmationRetracted", ValidationType.TYPE_FORMAT, "ConfirmationRetracted", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConfirmationRetracted o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ConfirmationRetracted", ValidationType.TYPE_FORMAT, "ConfirmationRetracted", path, "", res.getError());
				}
				return success("ConfirmationRetracted", ValidationType.TYPE_FORMAT, "ConfirmationRetracted", path, "");
			})
			.collect(toList());
	}

}
