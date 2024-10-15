package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GenericResetFrequency;
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

public class GenericResetFrequencyTypeFormatValidator implements Validator<GenericResetFrequency> {

	private List<ComparisonResult> getComparisonResults(GenericResetFrequency o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("periodMultiplier", o.getPeriodMultiplier(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public ValidationResult<GenericResetFrequency> validate(RosettaPath path, GenericResetFrequency o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GenericResetFrequency", ValidationType.TYPE_FORMAT, "GenericResetFrequency", path, "", error);
		}
		return success("GenericResetFrequency", ValidationType.TYPE_FORMAT, "GenericResetFrequency", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericResetFrequency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericResetFrequency", ValidationType.TYPE_FORMAT, "GenericResetFrequency", path, "", res.getError());
				}
				return success("GenericResetFrequency", ValidationType.TYPE_FORMAT, "GenericResetFrequency", path, "");
			})
			.collect(toList());
	}

}
