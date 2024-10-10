package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxCurveValuation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxCurveValuationTypeFormatValidator implements Validator<FxCurveValuation> {

	private List<ComparisonResult> getComparisonResults(FxCurveValuation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxCurveValuation> validate(RosettaPath path, FxCurveValuation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxCurveValuation", ValidationType.TYPE_FORMAT, "FxCurveValuation", path, "", error);
		}
		return success("FxCurveValuation", ValidationType.TYPE_FORMAT, "FxCurveValuation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxCurveValuation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxCurveValuation", ValidationType.TYPE_FORMAT, "FxCurveValuation", path, "", res.getError());
				}
				return success("FxCurveValuation", ValidationType.TYPE_FORMAT, "FxCurveValuation", path, "");
			})
			.collect(toList());
	}

}
