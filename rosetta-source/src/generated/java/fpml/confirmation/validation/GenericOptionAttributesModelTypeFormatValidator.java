package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GenericOptionAttributesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GenericOptionAttributesModelTypeFormatValidator implements Validator<GenericOptionAttributesModel> {

	private List<ComparisonResult> getComparisonResults(GenericOptionAttributesModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<GenericOptionAttributesModel> validate(RosettaPath path, GenericOptionAttributesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GenericOptionAttributesModel", ValidationType.TYPE_FORMAT, "GenericOptionAttributesModel", path, "", error);
		}
		return success("GenericOptionAttributesModel", ValidationType.TYPE_FORMAT, "GenericOptionAttributesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericOptionAttributesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericOptionAttributesModel", ValidationType.TYPE_FORMAT, "GenericOptionAttributesModel", path, "", res.getError());
				}
				return success("GenericOptionAttributesModel", ValidationType.TYPE_FORMAT, "GenericOptionAttributesModel", path, "");
			})
			.collect(toList());
	}

}
