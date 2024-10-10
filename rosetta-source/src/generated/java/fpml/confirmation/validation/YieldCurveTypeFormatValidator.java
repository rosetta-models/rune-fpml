package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.YieldCurve;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class YieldCurveTypeFormatValidator implements Validator<YieldCurve> {

	private List<ComparisonResult> getComparisonResults(YieldCurve o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<YieldCurve> validate(RosettaPath path, YieldCurve o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("YieldCurve", ValidationType.TYPE_FORMAT, "YieldCurve", path, "", error);
		}
		return success("YieldCurve", ValidationType.TYPE_FORMAT, "YieldCurve", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, YieldCurve o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("YieldCurve", ValidationType.TYPE_FORMAT, "YieldCurve", path, "", res.getError());
				}
				return success("YieldCurve", ValidationType.TYPE_FORMAT, "YieldCurve", path, "");
			})
			.collect(toList());
	}

}
