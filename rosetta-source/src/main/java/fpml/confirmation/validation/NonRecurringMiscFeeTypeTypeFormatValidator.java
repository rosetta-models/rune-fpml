package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NonRecurringMiscFeeType;
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

public class NonRecurringMiscFeeTypeTypeFormatValidator implements Validator<NonRecurringMiscFeeType> {

	private List<ComparisonResult> getComparisonResults(NonRecurringMiscFeeType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("nonRecurringMiscFeeTypeScheme", o.getNonRecurringMiscFeeTypeScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public ValidationResult<NonRecurringMiscFeeType> validate(RosettaPath path, NonRecurringMiscFeeType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NonRecurringMiscFeeType", ValidationType.TYPE_FORMAT, "NonRecurringMiscFeeType", path, "", error);
		}
		return success("NonRecurringMiscFeeType", ValidationType.TYPE_FORMAT, "NonRecurringMiscFeeType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonRecurringMiscFeeType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonRecurringMiscFeeType", ValidationType.TYPE_FORMAT, "NonRecurringMiscFeeType", path, "", res.getError());
				}
				return success("NonRecurringMiscFeeType", ValidationType.TYPE_FORMAT, "NonRecurringMiscFeeType", path, "");
			})
			.collect(toList());
	}

}
