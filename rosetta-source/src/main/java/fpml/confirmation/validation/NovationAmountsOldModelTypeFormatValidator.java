package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NovationAmountsOldModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NovationAmountsOldModelTypeFormatValidator implements Validator<NovationAmountsOldModel> {

	private List<ComparisonResult> getComparisonResults(NovationAmountsOldModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<NovationAmountsOldModel> validate(RosettaPath path, NovationAmountsOldModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NovationAmountsOldModel", ValidationType.TYPE_FORMAT, "NovationAmountsOldModel", path, "", error);
		}
		return success("NovationAmountsOldModel", ValidationType.TYPE_FORMAT, "NovationAmountsOldModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NovationAmountsOldModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NovationAmountsOldModel", ValidationType.TYPE_FORMAT, "NovationAmountsOldModel", path, "", res.getError());
				}
				return success("NovationAmountsOldModel", ValidationType.TYPE_FORMAT, "NovationAmountsOldModel", path, "");
			})
			.collect(toList());
	}

}
