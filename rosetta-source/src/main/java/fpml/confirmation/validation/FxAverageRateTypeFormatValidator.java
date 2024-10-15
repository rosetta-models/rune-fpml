package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAverageRate;
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

public class FxAverageRateTypeFormatValidator implements Validator<FxAverageRate> {

	private List<ComparisonResult> getComparisonResults(FxAverageRate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("precision", o.getPrecision(), empty(), of(0), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<FxAverageRate> validate(RosettaPath path, FxAverageRate o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAverageRate", ValidationType.TYPE_FORMAT, "FxAverageRate", path, "", error);
		}
		return success("FxAverageRate", ValidationType.TYPE_FORMAT, "FxAverageRate", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAverageRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAverageRate", ValidationType.TYPE_FORMAT, "FxAverageRate", path, "", res.getError());
				}
				return success("FxAverageRate", ValidationType.TYPE_FORMAT, "FxAverageRate", path, "");
			})
			.collect(toList());
	}

}
