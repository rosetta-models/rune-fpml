package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.YieldCurveValuation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class YieldCurveValuationTypeFormatValidator implements Validator<YieldCurveValuation> {

	private List<ComparisonResult> getComparisonResults(YieldCurveValuation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<YieldCurveValuation> validate(RosettaPath path, YieldCurveValuation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("YieldCurveValuation", ValidationType.TYPE_FORMAT, "YieldCurveValuation", path, "", error);
		}
		return success("YieldCurveValuation", ValidationType.TYPE_FORMAT, "YieldCurveValuation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, YieldCurveValuation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("YieldCurveValuation", ValidationType.TYPE_FORMAT, "YieldCurveValuation", path, "", res.getError());
				}
				return success("YieldCurveValuation", ValidationType.TYPE_FORMAT, "YieldCurveValuation", path, "");
			})
			.collect(toList());
	}

}
