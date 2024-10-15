package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Reason;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReasonTypeFormatValidator implements Validator<Reason> {

	private List<ComparisonResult> getComparisonResults(Reason o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("description", o.getDescription(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<Reason> validate(RosettaPath path, Reason o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Reason", ValidationType.TYPE_FORMAT, "Reason", path, "", error);
		}
		return success("Reason", ValidationType.TYPE_FORMAT, "Reason", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Reason o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Reason", ValidationType.TYPE_FORMAT, "Reason", path, "", res.getError());
				}
				return success("Reason", ValidationType.TYPE_FORMAT, "Reason", path, "");
			})
			.collect(toList());
	}

}
