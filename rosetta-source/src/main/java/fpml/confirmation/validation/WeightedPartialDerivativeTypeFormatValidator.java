package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.WeightedPartialDerivative;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class WeightedPartialDerivativeTypeFormatValidator implements Validator<WeightedPartialDerivative> {

	private List<ComparisonResult> getComparisonResults(WeightedPartialDerivative o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<WeightedPartialDerivative> validate(RosettaPath path, WeightedPartialDerivative o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("WeightedPartialDerivative", ValidationType.TYPE_FORMAT, "WeightedPartialDerivative", path, "", error);
		}
		return success("WeightedPartialDerivative", ValidationType.TYPE_FORMAT, "WeightedPartialDerivative", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeightedPartialDerivative o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WeightedPartialDerivative", ValidationType.TYPE_FORMAT, "WeightedPartialDerivative", path, "", res.getError());
				}
				return success("WeightedPartialDerivative", ValidationType.TYPE_FORMAT, "WeightedPartialDerivative", path, "");
			})
			.collect(toList());
	}

}
