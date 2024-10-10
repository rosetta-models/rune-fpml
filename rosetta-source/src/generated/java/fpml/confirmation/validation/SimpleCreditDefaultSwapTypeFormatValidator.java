package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SimpleCreditDefaultSwap;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SimpleCreditDefaultSwapTypeFormatValidator implements Validator<SimpleCreditDefaultSwap> {

	private List<ComparisonResult> getComparisonResults(SimpleCreditDefaultSwap o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("description", o.getDescription(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<SimpleCreditDefaultSwap> validate(RosettaPath path, SimpleCreditDefaultSwap o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SimpleCreditDefaultSwap", ValidationType.TYPE_FORMAT, "SimpleCreditDefaultSwap", path, "", error);
		}
		return success("SimpleCreditDefaultSwap", ValidationType.TYPE_FORMAT, "SimpleCreditDefaultSwap", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SimpleCreditDefaultSwap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SimpleCreditDefaultSwap", ValidationType.TYPE_FORMAT, "SimpleCreditDefaultSwap", path, "", res.getError());
				}
				return success("SimpleCreditDefaultSwap", ValidationType.TYPE_FORMAT, "SimpleCreditDefaultSwap", path, "");
			})
			.collect(toList());
	}

}
