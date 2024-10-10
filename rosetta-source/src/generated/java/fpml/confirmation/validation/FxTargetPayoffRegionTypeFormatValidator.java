package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTargetPayoffRegion;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetPayoffRegionTypeFormatValidator implements Validator<FxTargetPayoffRegion> {

	private List<ComparisonResult> getComparisonResults(FxTargetPayoffRegion o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxTargetPayoffRegion> validate(RosettaPath path, FxTargetPayoffRegion o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetPayoffRegion", ValidationType.TYPE_FORMAT, "FxTargetPayoffRegion", path, "", error);
		}
		return success("FxTargetPayoffRegion", ValidationType.TYPE_FORMAT, "FxTargetPayoffRegion", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetPayoffRegion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetPayoffRegion", ValidationType.TYPE_FORMAT, "FxTargetPayoffRegion", path, "", res.getError());
				}
				return success("FxTargetPayoffRegion", ValidationType.TYPE_FORMAT, "FxTargetPayoffRegion", path, "");
			})
			.collect(toList());
	}

}
