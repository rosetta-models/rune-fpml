package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTargetReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetReferenceTypeFormatValidator implements Validator<FxTargetReference> {

	private List<ComparisonResult> getComparisonResults(FxTargetReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxTargetReference> validate(RosettaPath path, FxTargetReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetReference", ValidationType.TYPE_FORMAT, "FxTargetReference", path, "", error);
		}
		return success("FxTargetReference", ValidationType.TYPE_FORMAT, "FxTargetReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetReference", ValidationType.TYPE_FORMAT, "FxTargetReference", path, "", res.getError());
				}
				return success("FxTargetReference", ValidationType.TYPE_FORMAT, "FxTargetReference", path, "");
			})
			.collect(toList());
	}

}
