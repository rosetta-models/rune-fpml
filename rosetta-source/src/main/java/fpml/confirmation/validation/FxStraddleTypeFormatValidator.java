package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxStraddle;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxStraddleTypeFormatValidator implements Validator<FxStraddle> {

	private List<ComparisonResult> getComparisonResults(FxStraddle o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxStraddle> validate(RosettaPath path, FxStraddle o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxStraddle", ValidationType.TYPE_FORMAT, "FxStraddle", path, "", error);
		}
		return success("FxStraddle", ValidationType.TYPE_FORMAT, "FxStraddle", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxStraddle o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxStraddle", ValidationType.TYPE_FORMAT, "FxStraddle", path, "", res.getError());
				}
				return success("FxStraddle", ValidationType.TYPE_FORMAT, "FxStraddle", path, "");
			})
			.collect(toList());
	}

}
