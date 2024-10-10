package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DelayedDraw;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DelayedDrawTypeFormatValidator implements Validator<DelayedDraw> {

	private List<ComparisonResult> getComparisonResults(DelayedDraw o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("description", o.getDescription(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<DelayedDraw> validate(RosettaPath path, DelayedDraw o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DelayedDraw", ValidationType.TYPE_FORMAT, "DelayedDraw", path, "", error);
		}
		return success("DelayedDraw", ValidationType.TYPE_FORMAT, "DelayedDraw", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DelayedDraw o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DelayedDraw", ValidationType.TYPE_FORMAT, "DelayedDraw", path, "", res.getError());
				}
				return success("DelayedDraw", ValidationType.TYPE_FORMAT, "DelayedDraw", path, "");
			})
			.collect(toList());
	}

}
