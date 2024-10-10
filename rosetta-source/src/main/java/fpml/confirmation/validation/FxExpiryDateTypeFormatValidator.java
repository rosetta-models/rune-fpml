package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxExpiryDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxExpiryDateTypeFormatValidator implements Validator<FxExpiryDate> {

	private List<ComparisonResult> getComparisonResults(FxExpiryDate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxExpiryDate> validate(RosettaPath path, FxExpiryDate o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxExpiryDate", ValidationType.TYPE_FORMAT, "FxExpiryDate", path, "", error);
		}
		return success("FxExpiryDate", ValidationType.TYPE_FORMAT, "FxExpiryDate", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxExpiryDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxExpiryDate", ValidationType.TYPE_FORMAT, "FxExpiryDate", path, "", res.getError());
				}
				return success("FxExpiryDate", ValidationType.TYPE_FORMAT, "FxExpiryDate", path, "");
			})
			.collect(toList());
	}

}
