package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OptionFeatures;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionFeaturesTypeFormatValidator implements Validator<OptionFeatures> {

	private List<ComparisonResult> getComparisonResults(OptionFeatures o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<OptionFeatures> validate(RosettaPath path, OptionFeatures o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionFeatures", ValidationType.TYPE_FORMAT, "OptionFeatures", path, "", error);
		}
		return success("OptionFeatures", ValidationType.TYPE_FORMAT, "OptionFeatures", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionFeatures o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionFeatures", ValidationType.TYPE_FORMAT, "OptionFeatures", path, "", res.getError());
				}
				return success("OptionFeatures", ValidationType.TYPE_FORMAT, "OptionFeatures", path, "");
			})
			.collect(toList());
	}

}
