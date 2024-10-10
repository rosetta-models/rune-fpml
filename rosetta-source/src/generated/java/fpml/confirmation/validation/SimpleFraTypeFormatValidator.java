package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SimpleFra;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SimpleFraTypeFormatValidator implements Validator<SimpleFra> {

	private List<ComparisonResult> getComparisonResults(SimpleFra o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("description", o.getDescription(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<SimpleFra> validate(RosettaPath path, SimpleFra o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SimpleFra", ValidationType.TYPE_FORMAT, "SimpleFra", path, "", error);
		}
		return success("SimpleFra", ValidationType.TYPE_FORMAT, "SimpleFra", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SimpleFra o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SimpleFra", ValidationType.TYPE_FORMAT, "SimpleFra", path, "", res.getError());
				}
				return success("SimpleFra", ValidationType.TYPE_FORMAT, "SimpleFra", path, "");
			})
			.collect(toList());
	}

}
