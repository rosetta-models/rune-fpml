package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ForwardRateCurve;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ForwardRateCurveTypeFormatValidator implements Validator<ForwardRateCurve> {

	private List<ComparisonResult> getComparisonResults(ForwardRateCurve o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ForwardRateCurve> validate(RosettaPath path, ForwardRateCurve o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ForwardRateCurve", ValidationType.TYPE_FORMAT, "ForwardRateCurve", path, "", error);
		}
		return success("ForwardRateCurve", ValidationType.TYPE_FORMAT, "ForwardRateCurve", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ForwardRateCurve o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ForwardRateCurve", ValidationType.TYPE_FORMAT, "ForwardRateCurve", path, "", res.getError());
				}
				return success("ForwardRateCurve", ValidationType.TYPE_FORMAT, "ForwardRateCurve", path, "");
			})
			.collect(toList());
	}

}
