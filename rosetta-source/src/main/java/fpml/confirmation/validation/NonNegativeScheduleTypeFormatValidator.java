package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NonNegativeSchedule;
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

public class NonNegativeScheduleTypeFormatValidator implements Validator<NonNegativeSchedule> {

	private List<ComparisonResult> getComparisonResults(NonNegativeSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("initialValue", o.getInitialValue(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<NonNegativeSchedule> validate(RosettaPath path, NonNegativeSchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NonNegativeSchedule", ValidationType.TYPE_FORMAT, "NonNegativeSchedule", path, "", error);
		}
		return success("NonNegativeSchedule", ValidationType.TYPE_FORMAT, "NonNegativeSchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonNegativeSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonNegativeSchedule", ValidationType.TYPE_FORMAT, "NonNegativeSchedule", path, "", res.getError());
				}
				return success("NonNegativeSchedule", ValidationType.TYPE_FORMAT, "NonNegativeSchedule", path, "");
			})
			.collect(toList());
	}

}
