package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTargetLinearPayoffRegion;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetLinearPayoffRegionTypeFormatValidator implements Validator<FxTargetLinearPayoffRegion> {

	private List<ComparisonResult> getComparisonResults(FxTargetLinearPayoffRegion o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxTargetLinearPayoffRegion> validate(RosettaPath path, FxTargetLinearPayoffRegion o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetLinearPayoffRegion", ValidationType.TYPE_FORMAT, "FxTargetLinearPayoffRegion", path, "", error);
		}
		return success("FxTargetLinearPayoffRegion", ValidationType.TYPE_FORMAT, "FxTargetLinearPayoffRegion", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetLinearPayoffRegion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetLinearPayoffRegion", ValidationType.TYPE_FORMAT, "FxTargetLinearPayoffRegion", path, "", res.getError());
				}
				return success("FxTargetLinearPayoffRegion", ValidationType.TYPE_FORMAT, "FxTargetLinearPayoffRegion", path, "");
			})
			.collect(toList());
	}

}
