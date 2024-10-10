package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CountryCode;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountryCodeValidator implements Validator<CountryCode> {

	private List<ComparisonResult> getComparisonResults(CountryCode o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("countryScheme", (String) o.getCountryScheme() != null ? 1 : 0, 0, 1)
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
			return failure("CountryCode", ValidationType.CARDINALITY, "CountryCode", path, "", error);
		}
		return success("CountryCode", ValidationType.CARDINALITY, "CountryCode", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CountryCode o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CountryCode", ValidationType.CARDINALITY, "CountryCode", path, "", res.getError());
				}
				return success("CountryCode", ValidationType.CARDINALITY, "CountryCode", path, "");
			})
			.collect(toList());
	}

}
