package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SPKIDataType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SPKIDataTypeTypeFormatValidator implements Validator<SPKIDataType> {

	private List<ComparisonResult> getComparisonResults(SPKIDataType o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<SPKIDataType> validate(RosettaPath path, SPKIDataType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SPKIDataType", ValidationType.TYPE_FORMAT, "SPKIDataType", path, "", error);
		}
		return success("SPKIDataType", ValidationType.TYPE_FORMAT, "SPKIDataType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SPKIDataType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SPKIDataType", ValidationType.TYPE_FORMAT, "SPKIDataType", path, "", res.getError());
				}
				return success("SPKIDataType", ValidationType.TYPE_FORMAT, "SPKIDataType", path, "");
			})
			.collect(toList());
	}

}
