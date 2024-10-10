package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FacilityRolesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FacilityRolesModelTypeFormatValidator implements Validator<FacilityRolesModel> {

	private List<ComparisonResult> getComparisonResults(FacilityRolesModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FacilityRolesModel> validate(RosettaPath path, FacilityRolesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FacilityRolesModel", ValidationType.TYPE_FORMAT, "FacilityRolesModel", path, "", error);
		}
		return success("FacilityRolesModel", ValidationType.TYPE_FORMAT, "FacilityRolesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FacilityRolesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FacilityRolesModel", ValidationType.TYPE_FORMAT, "FacilityRolesModel", path, "", res.getError());
				}
				return success("FacilityRolesModel", ValidationType.TYPE_FORMAT, "FacilityRolesModel", path, "");
			})
			.collect(toList());
	}

}
