package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityFeaturesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityFeaturesModelTypeFormatValidator implements Validator<FacilityFeaturesModel> {

	private List<ComparisonResult> getComparisonResults(FacilityFeaturesModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FacilityFeaturesModel> validate(RosettaPath path, FacilityFeaturesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityFeaturesModel", ValidationType.TYPE_FORMAT, "FacilityFeaturesModel", path, "", error);
		}
		return success("FacilityFeaturesModel", ValidationType.TYPE_FORMAT, "FacilityFeaturesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityFeaturesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityFeaturesModel", ValidationType.TYPE_FORMAT, "FacilityFeaturesModel", path, "", res.getError());
				}
				return success("FacilityFeaturesModel", ValidationType.TYPE_FORMAT, "FacilityFeaturesModel", path, "");
			})
			.collect(toList());
	}

}
