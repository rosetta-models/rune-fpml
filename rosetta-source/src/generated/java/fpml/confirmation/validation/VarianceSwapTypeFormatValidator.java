package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.VarianceSwap;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VarianceSwapTypeFormatValidator implements Validator<VarianceSwap> {

	private List<ComparisonResult> getComparisonResults(VarianceSwap o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<VarianceSwap> validate(RosettaPath path, VarianceSwap o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VarianceSwap", ValidationType.TYPE_FORMAT, "VarianceSwap", path, "", error);
		}
		return success("VarianceSwap", ValidationType.TYPE_FORMAT, "VarianceSwap", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceSwap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VarianceSwap", ValidationType.TYPE_FORMAT, "VarianceSwap", path, "", res.getError());
				}
				return success("VarianceSwap", ValidationType.TYPE_FORMAT, "VarianceSwap", path, "");
			})
			.collect(toList());
	}

}
