package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OptionType;
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

public class OptionTypeTypeFormatValidator implements Validator<OptionType> {

	private List<ComparisonResult> getComparisonResults(OptionType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("optionTypeScheme", o.getOptionTypeScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public ValidationResult<OptionType> validate(RosettaPath path, OptionType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionType", ValidationType.TYPE_FORMAT, "OptionType", path, "", error);
		}
		return success("OptionType", ValidationType.TYPE_FORMAT, "OptionType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionType", ValidationType.TYPE_FORMAT, "OptionType", path, "", res.getError());
				}
				return success("OptionType", ValidationType.TYPE_FORMAT, "OptionType", path, "");
			})
			.collect(toList());
	}

}
