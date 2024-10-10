package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxPerformanceFixedLeg;
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

public class FxPerformanceFixedLegTypeFormatValidator implements Validator<FxPerformanceFixedLeg> {

	private List<ComparisonResult> getComparisonResults(FxPerformanceFixedLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("fixedRate", o.getFixedRate(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<FxPerformanceFixedLeg> validate(RosettaPath path, FxPerformanceFixedLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxPerformanceFixedLeg", ValidationType.TYPE_FORMAT, "FxPerformanceFixedLeg", path, "", error);
		}
		return success("FxPerformanceFixedLeg", ValidationType.TYPE_FORMAT, "FxPerformanceFixedLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxPerformanceFixedLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxPerformanceFixedLeg", ValidationType.TYPE_FORMAT, "FxPerformanceFixedLeg", path, "", res.getError());
				}
				return success("FxPerformanceFixedLeg", ValidationType.TYPE_FORMAT, "FxPerformanceFixedLeg", path, "");
			})
			.collect(toList());
	}

}
