package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTargetAccumulationRegion;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetAccumulationRegionTypeFormatValidator implements Validator<FxTargetAccumulationRegion> {

	private List<ComparisonResult> getComparisonResults(FxTargetAccumulationRegion o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxTargetAccumulationRegion> validate(RosettaPath path, FxTargetAccumulationRegion o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetAccumulationRegion", ValidationType.TYPE_FORMAT, "FxTargetAccumulationRegion", path, "", error);
		}
		return success("FxTargetAccumulationRegion", ValidationType.TYPE_FORMAT, "FxTargetAccumulationRegion", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetAccumulationRegion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetAccumulationRegion", ValidationType.TYPE_FORMAT, "FxTargetAccumulationRegion", path, "", res.getError());
				}
				return success("FxTargetAccumulationRegion", ValidationType.TYPE_FORMAT, "FxTargetAccumulationRegion", path, "");
			})
			.collect(toList());
	}

}
