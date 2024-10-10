package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxComplexBarrierBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxComplexBarrierBaseTypeFormatValidator implements Validator<FxComplexBarrierBase> {

	private List<ComparisonResult> getComparisonResults(FxComplexBarrierBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxComplexBarrierBase> validate(RosettaPath path, FxComplexBarrierBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxComplexBarrierBase", ValidationType.TYPE_FORMAT, "FxComplexBarrierBase", path, "", error);
		}
		return success("FxComplexBarrierBase", ValidationType.TYPE_FORMAT, "FxComplexBarrierBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxComplexBarrierBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxComplexBarrierBase", ValidationType.TYPE_FORMAT, "FxComplexBarrierBase", path, "", res.getError());
				}
				return success("FxComplexBarrierBase", ValidationType.TYPE_FORMAT, "FxComplexBarrierBase", path, "");
			})
			.collect(toList());
	}

}
