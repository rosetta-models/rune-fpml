package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NovationDatesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NovationDatesModelTypeFormatValidator implements Validator<NovationDatesModel> {

	private List<ComparisonResult> getComparisonResults(NovationDatesModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<NovationDatesModel> validate(RosettaPath path, NovationDatesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NovationDatesModel", ValidationType.TYPE_FORMAT, "NovationDatesModel", path, "", error);
		}
		return success("NovationDatesModel", ValidationType.TYPE_FORMAT, "NovationDatesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NovationDatesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NovationDatesModel", ValidationType.TYPE_FORMAT, "NovationDatesModel", path, "", res.getError());
				}
				return success("NovationDatesModel", ValidationType.TYPE_FORMAT, "NovationDatesModel", path, "");
			})
			.collect(toList());
	}

}
