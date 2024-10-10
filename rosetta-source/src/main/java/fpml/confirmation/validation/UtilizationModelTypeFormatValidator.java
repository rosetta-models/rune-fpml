package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.UtilizationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class UtilizationModelTypeFormatValidator implements Validator<UtilizationModel> {

	private List<ComparisonResult> getComparisonResults(UtilizationModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<UtilizationModel> validate(RosettaPath path, UtilizationModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("UtilizationModel", ValidationType.TYPE_FORMAT, "UtilizationModel", path, "", error);
		}
		return success("UtilizationModel", ValidationType.TYPE_FORMAT, "UtilizationModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UtilizationModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UtilizationModel", ValidationType.TYPE_FORMAT, "UtilizationModel", path, "", res.getError());
				}
				return success("UtilizationModel", ValidationType.TYPE_FORMAT, "UtilizationModel", path, "");
			})
			.collect(toList());
	}

}
