package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Fra;
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

public class FraTypeFormatValidator implements Validator<Fra> {

	private List<ComparisonResult> getComparisonResults(Fra o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("calculationPeriodNumberOfDays", o.getCalculationPeriodNumberOfDays(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public ValidationResult<Fra> validate(RosettaPath path, Fra o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Fra", ValidationType.TYPE_FORMAT, "Fra", path, "", error);
		}
		return success("Fra", ValidationType.TYPE_FORMAT, "Fra", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Fra o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Fra", ValidationType.TYPE_FORMAT, "Fra", path, "", res.getError());
				}
				return success("Fra", ValidationType.TYPE_FORMAT, "Fra", path, "");
			})
			.collect(toList());
	}

}
