package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReturnSwapNotionalAmountReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReturnSwapNotionalAmountReferenceTypeFormatValidator implements Validator<ReturnSwapNotionalAmountReference> {

	private List<ComparisonResult> getComparisonResults(ReturnSwapNotionalAmountReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ReturnSwapNotionalAmountReference> validate(RosettaPath path, ReturnSwapNotionalAmountReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReturnSwapNotionalAmountReference", ValidationType.TYPE_FORMAT, "ReturnSwapNotionalAmountReference", path, "", error);
		}
		return success("ReturnSwapNotionalAmountReference", ValidationType.TYPE_FORMAT, "ReturnSwapNotionalAmountReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapNotionalAmountReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnSwapNotionalAmountReference", ValidationType.TYPE_FORMAT, "ReturnSwapNotionalAmountReference", path, "", res.getError());
				}
				return success("ReturnSwapNotionalAmountReference", ValidationType.TYPE_FORMAT, "ReturnSwapNotionalAmountReference", path, "");
			})
			.collect(toList());
	}

}
