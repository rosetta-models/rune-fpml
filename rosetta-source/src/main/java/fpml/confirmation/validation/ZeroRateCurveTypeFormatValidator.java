package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ZeroRateCurve;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ZeroRateCurveTypeFormatValidator implements Validator<ZeroRateCurve> {

	private List<ComparisonResult> getComparisonResults(ZeroRateCurve o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ZeroRateCurve> validate(RosettaPath path, ZeroRateCurve o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ZeroRateCurve", ValidationType.TYPE_FORMAT, "ZeroRateCurve", path, "", error);
		}
		return success("ZeroRateCurve", ValidationType.TYPE_FORMAT, "ZeroRateCurve", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ZeroRateCurve o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ZeroRateCurve", ValidationType.TYPE_FORMAT, "ZeroRateCurve", path, "", res.getError());
				}
				return success("ZeroRateCurve", ValidationType.TYPE_FORMAT, "ZeroRateCurve", path, "");
			})
			.collect(toList());
	}

}
