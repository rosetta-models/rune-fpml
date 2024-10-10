package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SPKIData;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SPKIDataTypeFormatValidator implements Validator<SPKIData> {

	private List<ComparisonResult> getComparisonResults(SPKIData o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<SPKIData> validate(RosettaPath path, SPKIData o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SPKIData", ValidationType.TYPE_FORMAT, "SPKIData", path, "", error);
		}
		return success("SPKIData", ValidationType.TYPE_FORMAT, "SPKIData", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SPKIData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SPKIData", ValidationType.TYPE_FORMAT, "SPKIData", path, "", res.getError());
				}
				return success("SPKIData", ValidationType.TYPE_FORMAT, "SPKIData", path, "");
			})
			.collect(toList());
	}

}
