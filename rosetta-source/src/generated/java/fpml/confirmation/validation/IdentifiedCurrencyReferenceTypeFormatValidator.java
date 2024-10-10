package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IdentifiedCurrencyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class IdentifiedCurrencyReferenceTypeFormatValidator implements Validator<IdentifiedCurrencyReference> {

	private List<ComparisonResult> getComparisonResults(IdentifiedCurrencyReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<IdentifiedCurrencyReference> validate(RosettaPath path, IdentifiedCurrencyReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("IdentifiedCurrencyReference", ValidationType.TYPE_FORMAT, "IdentifiedCurrencyReference", path, "", error);
		}
		return success("IdentifiedCurrencyReference", ValidationType.TYPE_FORMAT, "IdentifiedCurrencyReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IdentifiedCurrencyReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IdentifiedCurrencyReference", ValidationType.TYPE_FORMAT, "IdentifiedCurrencyReference", path, "", res.getError());
				}
				return success("IdentifiedCurrencyReference", ValidationType.TYPE_FORMAT, "IdentifiedCurrencyReference", path, "");
			})
			.collect(toList());
	}

}
