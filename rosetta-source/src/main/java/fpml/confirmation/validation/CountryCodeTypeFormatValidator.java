package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CountryCode;
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

public class CountryCodeTypeFormatValidator implements Validator<CountryCode> {

	private List<ComparisonResult> getComparisonResults(CountryCode o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("countryScheme", o.getCountryScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public ValidationResult<CountryCode> validate(RosettaPath path, CountryCode o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CountryCode", ValidationType.TYPE_FORMAT, "CountryCode", path, "", error);
		}
		return success("CountryCode", ValidationType.TYPE_FORMAT, "CountryCode", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CountryCode o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CountryCode", ValidationType.TYPE_FORMAT, "CountryCode", path, "", res.getError());
				}
				return success("CountryCode", ValidationType.TYPE_FORMAT, "CountryCode", path, "");
			})
			.collect(toList());
	}

}
