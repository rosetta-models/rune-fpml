package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Language;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LanguageValidator implements Validator<Language> {

	private List<ComparisonResult> getComparisonResults(Language o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("languageScheme", (String) o.getLanguageScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Language> validate(RosettaPath path, Language o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Language", ValidationType.CARDINALITY, "Language", path, "", error);
		}
		return success("Language", ValidationType.CARDINALITY, "Language", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Language o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Language", ValidationType.CARDINALITY, "Language", path, "", res.getError());
				}
				return success("Language", ValidationType.CARDINALITY, "Language", path, "");
			})
			.collect(toList());
	}

}
