package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxDisruption;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxDisruptionTypeFormatValidator implements Validator<FxDisruption> {

	private List<ComparisonResult> getComparisonResults(FxDisruption o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxDisruption> validate(RosettaPath path, FxDisruption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxDisruption", ValidationType.TYPE_FORMAT, "FxDisruption", path, "", error);
		}
		return success("FxDisruption", ValidationType.TYPE_FORMAT, "FxDisruption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxDisruption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxDisruption", ValidationType.TYPE_FORMAT, "FxDisruption", path, "", res.getError());
				}
				return success("FxDisruption", ValidationType.TYPE_FORMAT, "FxDisruption", path, "");
			})
			.collect(toList());
	}

}
