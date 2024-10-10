package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxDateOffset;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxDateOffsetTypeFormatValidator implements Validator<FxDateOffset> {

	private List<ComparisonResult> getComparisonResults(FxDateOffset o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxDateOffset> validate(RosettaPath path, FxDateOffset o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxDateOffset", ValidationType.TYPE_FORMAT, "FxDateOffset", path, "", error);
		}
		return success("FxDateOffset", ValidationType.TYPE_FORMAT, "FxDateOffset", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxDateOffset o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxDateOffset", ValidationType.TYPE_FORMAT, "FxDateOffset", path, "", res.getError());
				}
				return success("FxDateOffset", ValidationType.TYPE_FORMAT, "FxDateOffset", path, "");
			})
			.collect(toList());
	}

}
