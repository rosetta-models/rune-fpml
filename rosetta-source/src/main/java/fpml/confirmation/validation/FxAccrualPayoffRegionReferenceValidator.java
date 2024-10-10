package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualPayoffRegionReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualPayoffRegionReferenceValidator implements Validator<FxAccrualPayoffRegionReference> {

	private List<ComparisonResult> getComparisonResults(FxAccrualPayoffRegionReference o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("href", (String) o.getHref() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxAccrualPayoffRegionReference> validate(RosettaPath path, FxAccrualPayoffRegionReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualPayoffRegionReference", ValidationType.CARDINALITY, "FxAccrualPayoffRegionReference", path, "", error);
		}
		return success("FxAccrualPayoffRegionReference", ValidationType.CARDINALITY, "FxAccrualPayoffRegionReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualPayoffRegionReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualPayoffRegionReference", ValidationType.CARDINALITY, "FxAccrualPayoffRegionReference", path, "", res.getError());
				}
				return success("FxAccrualPayoffRegionReference", ValidationType.CARDINALITY, "FxAccrualPayoffRegionReference", path, "");
			})
			.collect(toList());
	}

}
