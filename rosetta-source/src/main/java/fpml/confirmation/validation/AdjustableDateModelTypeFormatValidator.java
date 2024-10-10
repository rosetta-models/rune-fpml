package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableDateModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AdjustableDateModelTypeFormatValidator implements Validator<AdjustableDateModel> {

	private List<ComparisonResult> getComparisonResults(AdjustableDateModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<AdjustableDateModel> validate(RosettaPath path, AdjustableDateModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AdjustableDateModel", ValidationType.TYPE_FORMAT, "AdjustableDateModel", path, "", error);
		}
		return success("AdjustableDateModel", ValidationType.TYPE_FORMAT, "AdjustableDateModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableDateModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdjustableDateModel", ValidationType.TYPE_FORMAT, "AdjustableDateModel", path, "", res.getError());
				}
				return success("AdjustableDateModel", ValidationType.TYPE_FORMAT, "AdjustableDateModel", path, "");
			})
			.collect(toList());
	}

}
