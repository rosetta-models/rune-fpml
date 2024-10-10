package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxPayoffCap;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxPayoffCapTypeFormatValidator implements Validator<FxPayoffCap> {

	private List<ComparisonResult> getComparisonResults(FxPayoffCap o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxPayoffCap> validate(RosettaPath path, FxPayoffCap o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxPayoffCap", ValidationType.TYPE_FORMAT, "FxPayoffCap", path, "", error);
		}
		return success("FxPayoffCap", ValidationType.TYPE_FORMAT, "FxPayoffCap", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxPayoffCap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxPayoffCap", ValidationType.TYPE_FORMAT, "FxPayoffCap", path, "", res.getError());
				}
				return success("FxPayoffCap", ValidationType.TYPE_FORMAT, "FxPayoffCap", path, "");
			})
			.collect(toList());
	}

}
