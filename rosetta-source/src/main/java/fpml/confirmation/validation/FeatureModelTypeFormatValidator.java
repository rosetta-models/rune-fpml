package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FeatureModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FeatureModelTypeFormatValidator implements Validator<FeatureModel> {

	private List<ComparisonResult> getComparisonResults(FeatureModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FeatureModel> validate(RosettaPath path, FeatureModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FeatureModel", ValidationType.TYPE_FORMAT, "FeatureModel", path, "", error);
		}
		return success("FeatureModel", ValidationType.TYPE_FORMAT, "FeatureModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FeatureModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FeatureModel", ValidationType.TYPE_FORMAT, "FeatureModel", path, "", res.getError());
				}
				return success("FeatureModel", ValidationType.TYPE_FORMAT, "FeatureModel", path, "");
			})
			.collect(toList());
	}

}
