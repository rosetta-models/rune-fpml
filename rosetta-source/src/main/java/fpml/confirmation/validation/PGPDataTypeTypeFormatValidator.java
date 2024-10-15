package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PGPDataType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PGPDataTypeTypeFormatValidator implements Validator<PGPDataType> {

	private List<ComparisonResult> getComparisonResults(PGPDataType o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PGPDataType> validate(RosettaPath path, PGPDataType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PGPDataType", ValidationType.TYPE_FORMAT, "PGPDataType", path, "", error);
		}
		return success("PGPDataType", ValidationType.TYPE_FORMAT, "PGPDataType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PGPDataType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PGPDataType", ValidationType.TYPE_FORMAT, "PGPDataType", path, "", res.getError());
				}
				return success("PGPDataType", ValidationType.TYPE_FORMAT, "PGPDataType", path, "");
			})
			.collect(toList());
	}

}
