package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.YieldCurveMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class YieldCurveMethodTypeFormatValidator implements Validator<YieldCurveMethod> {

	private List<ComparisonResult> getComparisonResults(YieldCurveMethod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<YieldCurveMethod> validate(RosettaPath path, YieldCurveMethod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("YieldCurveMethod", ValidationType.TYPE_FORMAT, "YieldCurveMethod", path, "", error);
		}
		return success("YieldCurveMethod", ValidationType.TYPE_FORMAT, "YieldCurveMethod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, YieldCurveMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("YieldCurveMethod", ValidationType.TYPE_FORMAT, "YieldCurveMethod", path, "", res.getError());
				}
				return success("YieldCurveMethod", ValidationType.TYPE_FORMAT, "YieldCurveMethod", path, "");
			})
			.collect(toList());
	}

}
