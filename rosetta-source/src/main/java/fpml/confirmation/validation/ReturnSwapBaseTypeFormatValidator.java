package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReturnSwapBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReturnSwapBaseTypeFormatValidator implements Validator<ReturnSwapBase> {

	private List<ComparisonResult> getComparisonResults(ReturnSwapBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ReturnSwapBase> validate(RosettaPath path, ReturnSwapBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReturnSwapBase", ValidationType.TYPE_FORMAT, "ReturnSwapBase", path, "", error);
		}
		return success("ReturnSwapBase", ValidationType.TYPE_FORMAT, "ReturnSwapBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnSwapBase", ValidationType.TYPE_FORMAT, "ReturnSwapBase", path, "", res.getError());
				}
				return success("ReturnSwapBase", ValidationType.TYPE_FORMAT, "ReturnSwapBase", path, "");
			})
			.collect(toList());
	}

}
