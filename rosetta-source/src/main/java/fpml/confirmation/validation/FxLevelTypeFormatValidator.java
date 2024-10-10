package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxLevel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxLevelTypeFormatValidator implements Validator<FxLevel> {

	private List<ComparisonResult> getComparisonResults(FxLevel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxLevel> validate(RosettaPath path, FxLevel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxLevel", ValidationType.TYPE_FORMAT, "FxLevel", path, "", error);
		}
		return success("FxLevel", ValidationType.TYPE_FORMAT, "FxLevel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxLevel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxLevel", ValidationType.TYPE_FORMAT, "FxLevel", path, "", res.getError());
				}
				return success("FxLevel", ValidationType.TYPE_FORMAT, "FxLevel", path, "");
			})
			.collect(toList());
	}

}
