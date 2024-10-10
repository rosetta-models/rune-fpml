package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAveragingProcess;
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

public class FxAveragingProcessTypeFormatValidator implements Validator<FxAveragingProcess> {

	private List<ComparisonResult> getComparisonResults(FxAveragingProcess o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("precision", o.getPrecision(), empty(), of(0), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<FxAveragingProcess> validate(RosettaPath path, FxAveragingProcess o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAveragingProcess", ValidationType.TYPE_FORMAT, "FxAveragingProcess", path, "", error);
		}
		return success("FxAveragingProcess", ValidationType.TYPE_FORMAT, "FxAveragingProcess", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAveragingProcess o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAveragingProcess", ValidationType.TYPE_FORMAT, "FxAveragingProcess", path, "", res.getError());
				}
				return success("FxAveragingProcess", ValidationType.TYPE_FORMAT, "FxAveragingProcess", path, "");
			})
			.collect(toList());
	}

}
