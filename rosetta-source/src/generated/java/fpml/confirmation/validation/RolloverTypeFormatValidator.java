package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Rollover;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RolloverTypeFormatValidator implements Validator<Rollover> {

	private List<ComparisonResult> getComparisonResults(Rollover o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<Rollover> validate(RosettaPath path, Rollover o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Rollover", ValidationType.TYPE_FORMAT, "Rollover", path, "", error);
		}
		return success("Rollover", ValidationType.TYPE_FORMAT, "Rollover", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Rollover o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Rollover", ValidationType.TYPE_FORMAT, "Rollover", path, "", res.getError());
				}
				return success("Rollover", ValidationType.TYPE_FORMAT, "Rollover", path, "");
			})
			.collect(toList());
	}

}
