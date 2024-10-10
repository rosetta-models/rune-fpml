package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Swap;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SwapTypeFormatValidator implements Validator<Swap> {

	private List<ComparisonResult> getComparisonResults(Swap o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Swap> validate(RosettaPath path, Swap o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Swap", ValidationType.TYPE_FORMAT, "Swap", path, "", error);
		}
		return success("Swap", ValidationType.TYPE_FORMAT, "Swap", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Swap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Swap", ValidationType.TYPE_FORMAT, "Swap", path, "", res.getError());
				}
				return success("Swap", ValidationType.TYPE_FORMAT, "Swap", path, "");
			})
			.collect(toList());
	}

}
