package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityDatesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityDatesModelTypeFormatValidator implements Validator<FacilityDatesModel> {

	private List<ComparisonResult> getComparisonResults(FacilityDatesModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FacilityDatesModel> validate(RosettaPath path, FacilityDatesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityDatesModel", ValidationType.TYPE_FORMAT, "FacilityDatesModel", path, "", error);
		}
		return success("FacilityDatesModel", ValidationType.TYPE_FORMAT, "FacilityDatesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityDatesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityDatesModel", ValidationType.TYPE_FORMAT, "FacilityDatesModel", path, "", res.getError());
				}
				return success("FacilityDatesModel", ValidationType.TYPE_FORMAT, "FacilityDatesModel", path, "");
			})
			.collect(toList());
	}

}
