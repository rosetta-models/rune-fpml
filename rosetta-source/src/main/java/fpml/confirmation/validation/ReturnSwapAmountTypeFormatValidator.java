package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReturnSwapAmount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReturnSwapAmountTypeFormatValidator implements Validator<ReturnSwapAmount> {

	private List<ComparisonResult> getComparisonResults(ReturnSwapAmount o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ReturnSwapAmount> validate(RosettaPath path, ReturnSwapAmount o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReturnSwapAmount", ValidationType.TYPE_FORMAT, "ReturnSwapAmount", path, "", error);
		}
		return success("ReturnSwapAmount", ValidationType.TYPE_FORMAT, "ReturnSwapAmount", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnSwapAmount", ValidationType.TYPE_FORMAT, "ReturnSwapAmount", path, "", res.getError());
				}
				return success("ReturnSwapAmount", ValidationType.TYPE_FORMAT, "ReturnSwapAmount", path, "");
			})
			.collect(toList());
	}

}
