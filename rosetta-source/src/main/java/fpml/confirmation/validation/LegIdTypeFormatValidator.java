package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LegId;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LegIdTypeFormatValidator implements Validator<LegId> {

	private List<ComparisonResult> getComparisonResults(LegId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("legIdScheme", o.getLegIdScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public ValidationResult<LegId> validate(RosettaPath path, LegId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LegId", ValidationType.TYPE_FORMAT, "LegId", path, "", error);
		}
		return success("LegId", ValidationType.TYPE_FORMAT, "LegId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegId", ValidationType.TYPE_FORMAT, "LegId", path, "", res.getError());
				}
				return success("LegId", ValidationType.TYPE_FORMAT, "LegId", path, "");
			})
			.collect(toList());
	}

}
