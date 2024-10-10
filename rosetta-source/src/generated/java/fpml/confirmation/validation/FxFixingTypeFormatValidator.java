package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxFixing;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxFixingTypeFormatValidator implements Validator<FxFixing> {

	private List<ComparisonResult> getComparisonResults(FxFixing o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxFixing> validate(RosettaPath path, FxFixing o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxFixing", ValidationType.TYPE_FORMAT, "FxFixing", path, "", error);
		}
		return success("FxFixing", ValidationType.TYPE_FORMAT, "FxFixing", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFixing o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxFixing", ValidationType.TYPE_FORMAT, "FxFixing", path, "", res.getError());
				}
				return success("FxFixing", ValidationType.TYPE_FORMAT, "FxFixing", path, "");
			})
			.collect(toList());
	}

}
