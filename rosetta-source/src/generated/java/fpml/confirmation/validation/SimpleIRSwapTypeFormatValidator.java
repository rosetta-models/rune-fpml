package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SimpleIRSwap;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SimpleIRSwapTypeFormatValidator implements Validator<SimpleIRSwap> {

	private List<ComparisonResult> getComparisonResults(SimpleIRSwap o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("description", o.getDescription(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<SimpleIRSwap> validate(RosettaPath path, SimpleIRSwap o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SimpleIRSwap", ValidationType.TYPE_FORMAT, "SimpleIRSwap", path, "", error);
		}
		return success("SimpleIRSwap", ValidationType.TYPE_FORMAT, "SimpleIRSwap", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SimpleIRSwap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SimpleIRSwap", ValidationType.TYPE_FORMAT, "SimpleIRSwap", path, "", res.getError());
				}
				return success("SimpleIRSwap", ValidationType.TYPE_FORMAT, "SimpleIRSwap", path, "");
			})
			.collect(toList());
	}

}
