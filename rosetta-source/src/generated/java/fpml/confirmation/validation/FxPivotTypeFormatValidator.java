package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxPivot;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxPivotTypeFormatValidator implements Validator<FxPivot> {

	private List<ComparisonResult> getComparisonResults(FxPivot o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxPivot> validate(RosettaPath path, FxPivot o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxPivot", ValidationType.TYPE_FORMAT, "FxPivot", path, "", error);
		}
		return success("FxPivot", ValidationType.TYPE_FORMAT, "FxPivot", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxPivot o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxPivot", ValidationType.TYPE_FORMAT, "FxPivot", path, "", res.getError());
				}
				return success("FxPivot", ValidationType.TYPE_FORMAT, "FxPivot", path, "");
			})
			.collect(toList());
	}

}
