package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InterpolationMethod;
import fpml.confirmation.TermCurve;
import fpml.confirmation.TermPoint;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TermCurveValidator implements Validator<TermCurve> {

	private List<ComparisonResult> getComparisonResults(TermCurve o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("interpolationMethod", (InterpolationMethod) o.getInterpolationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("extrapolationPermitted", (Boolean) o.getExtrapolationPermitted() != null ? 1 : 0, 0, 1), 
				checkCardinality("point", (List<? extends TermPoint>) o.getPoint() == null ? 0 : ((List<? extends TermPoint>) o.getPoint()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<TermCurve> validate(RosettaPath path, TermCurve o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TermCurve", ValidationType.CARDINALITY, "TermCurve", path, "", error);
		}
		return success("TermCurve", ValidationType.CARDINALITY, "TermCurve", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TermCurve o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TermCurve", ValidationType.CARDINALITY, "TermCurve", path, "", res.getError());
				}
				return success("TermCurve", ValidationType.CARDINALITY, "TermCurve", path, "");
			})
			.collect(toList());
	}

}
