package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OptionFeatureModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionFeatureModelTypeFormatValidator implements Validator<OptionFeatureModel> {

	private List<ComparisonResult> getComparisonResults(OptionFeatureModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<OptionFeatureModel> validate(RosettaPath path, OptionFeatureModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionFeatureModel", ValidationType.TYPE_FORMAT, "OptionFeatureModel", path, "", error);
		}
		return success("OptionFeatureModel", ValidationType.TYPE_FORMAT, "OptionFeatureModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionFeatureModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionFeatureModel", ValidationType.TYPE_FORMAT, "OptionFeatureModel", path, "", res.getError());
				}
				return success("OptionFeatureModel", ValidationType.TYPE_FORMAT, "OptionFeatureModel", path, "");
			})
			.collect(toList());
	}

}
