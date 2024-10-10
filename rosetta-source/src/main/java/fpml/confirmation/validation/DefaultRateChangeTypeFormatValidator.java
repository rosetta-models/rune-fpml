package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DefaultRateChange;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DefaultRateChangeTypeFormatValidator implements Validator<DefaultRateChange> {

	private List<ComparisonResult> getComparisonResults(DefaultRateChange o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<DefaultRateChange> validate(RosettaPath path, DefaultRateChange o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DefaultRateChange", ValidationType.TYPE_FORMAT, "DefaultRateChange", path, "", error);
		}
		return success("DefaultRateChange", ValidationType.TYPE_FORMAT, "DefaultRateChange", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DefaultRateChange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DefaultRateChange", ValidationType.TYPE_FORMAT, "DefaultRateChange", path, "", res.getError());
				}
				return success("DefaultRateChange", ValidationType.TYPE_FORMAT, "DefaultRateChange", path, "");
			})
			.collect(toList());
	}

}
