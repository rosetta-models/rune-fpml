package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTargetLeverage;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetLeverageTypeFormatValidator implements Validator<FxTargetLeverage> {

	private List<ComparisonResult> getComparisonResults(FxTargetLeverage o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxTargetLeverage> validate(RosettaPath path, FxTargetLeverage o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetLeverage", ValidationType.TYPE_FORMAT, "FxTargetLeverage", path, "", error);
		}
		return success("FxTargetLeverage", ValidationType.TYPE_FORMAT, "FxTargetLeverage", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetLeverage o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetLeverage", ValidationType.TYPE_FORMAT, "FxTargetLeverage", path, "", res.getError());
				}
				return success("FxTargetLeverage", ValidationType.TYPE_FORMAT, "FxTargetLeverage", path, "");
			})
			.collect(toList());
	}

}
