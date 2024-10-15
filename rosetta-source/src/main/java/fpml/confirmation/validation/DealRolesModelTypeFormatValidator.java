package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DealRolesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DealRolesModelTypeFormatValidator implements Validator<DealRolesModel> {

	private List<ComparisonResult> getComparisonResults(DealRolesModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<DealRolesModel> validate(RosettaPath path, DealRolesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DealRolesModel", ValidationType.TYPE_FORMAT, "DealRolesModel", path, "", error);
		}
		return success("DealRolesModel", ValidationType.TYPE_FORMAT, "DealRolesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DealRolesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DealRolesModel", ValidationType.TYPE_FORMAT, "DealRolesModel", path, "", res.getError());
				}
				return success("DealRolesModel", ValidationType.TYPE_FORMAT, "DealRolesModel", path, "");
			})
			.collect(toList());
	}

}
