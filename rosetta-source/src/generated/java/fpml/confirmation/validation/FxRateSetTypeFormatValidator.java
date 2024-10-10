package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxRateSet;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxRateSetTypeFormatValidator implements Validator<FxRateSet> {

	private List<ComparisonResult> getComparisonResults(FxRateSet o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxRateSet> validate(RosettaPath path, FxRateSet o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxRateSet", ValidationType.TYPE_FORMAT, "FxRateSet", path, "", error);
		}
		return success("FxRateSet", ValidationType.TYPE_FORMAT, "FxRateSet", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxRateSet o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxRateSet", ValidationType.TYPE_FORMAT, "FxRateSet", path, "", res.getError());
				}
				return success("FxRateSet", ValidationType.TYPE_FORMAT, "FxRateSet", path, "");
			})
			.collect(toList());
	}

}
