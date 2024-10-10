package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReturnSwapLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReturnSwapLegTypeFormatValidator implements Validator<ReturnSwapLeg> {

	private List<ComparisonResult> getComparisonResults(ReturnSwapLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ReturnSwapLeg> validate(RosettaPath path, ReturnSwapLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReturnSwapLeg", ValidationType.TYPE_FORMAT, "ReturnSwapLeg", path, "", error);
		}
		return success("ReturnSwapLeg", ValidationType.TYPE_FORMAT, "ReturnSwapLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnSwapLeg", ValidationType.TYPE_FORMAT, "ReturnSwapLeg", path, "", res.getError());
				}
				return success("ReturnSwapLeg", ValidationType.TYPE_FORMAT, "ReturnSwapLeg", path, "");
			})
			.collect(toList());
	}

}
