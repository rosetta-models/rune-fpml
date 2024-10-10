package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DualCurrencyFeature;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DualCurrencyFeatureTypeFormatValidator implements Validator<DualCurrencyFeature> {

	private List<ComparisonResult> getComparisonResults(DualCurrencyFeature o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<DualCurrencyFeature> validate(RosettaPath path, DualCurrencyFeature o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DualCurrencyFeature", ValidationType.TYPE_FORMAT, "DualCurrencyFeature", path, "", error);
		}
		return success("DualCurrencyFeature", ValidationType.TYPE_FORMAT, "DualCurrencyFeature", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DualCurrencyFeature o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DualCurrencyFeature", ValidationType.TYPE_FORMAT, "DualCurrencyFeature", path, "", res.getError());
				}
				return success("DualCurrencyFeature", ValidationType.TYPE_FORMAT, "DualCurrencyFeature", path, "");
			})
			.collect(toList());
	}

}
