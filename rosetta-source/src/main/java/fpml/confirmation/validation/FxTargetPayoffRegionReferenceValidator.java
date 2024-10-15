package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTargetPayoffRegionReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetPayoffRegionReferenceValidator implements Validator<FxTargetPayoffRegionReference> {

	private List<ComparisonResult> getComparisonResults(FxTargetPayoffRegionReference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("href", (String) o.getHref() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxTargetPayoffRegionReference> validate(RosettaPath path, FxTargetPayoffRegionReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetPayoffRegionReference", ValidationType.CARDINALITY, "FxTargetPayoffRegionReference", path, "", error);
		}
		return success("FxTargetPayoffRegionReference", ValidationType.CARDINALITY, "FxTargetPayoffRegionReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetPayoffRegionReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetPayoffRegionReference", ValidationType.CARDINALITY, "FxTargetPayoffRegionReference", path, "", res.getError());
				}
				return success("FxTargetPayoffRegionReference", ValidationType.CARDINALITY, "FxTargetPayoffRegionReference", path, "");
			})
			.collect(toList());
	}

}
