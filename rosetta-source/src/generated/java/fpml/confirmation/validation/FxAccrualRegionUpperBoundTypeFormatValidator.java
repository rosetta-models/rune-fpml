package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualRegionUpperBound;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualRegionUpperBoundTypeFormatValidator implements Validator<FxAccrualRegionUpperBound> {

	private List<ComparisonResult> getComparisonResults(FxAccrualRegionUpperBound o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxAccrualRegionUpperBound> validate(RosettaPath path, FxAccrualRegionUpperBound o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualRegionUpperBound", ValidationType.TYPE_FORMAT, "FxAccrualRegionUpperBound", path, "", error);
		}
		return success("FxAccrualRegionUpperBound", ValidationType.TYPE_FORMAT, "FxAccrualRegionUpperBound", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualRegionUpperBound o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualRegionUpperBound", ValidationType.TYPE_FORMAT, "FxAccrualRegionUpperBound", path, "", res.getError());
				}
				return success("FxAccrualRegionUpperBound", ValidationType.TYPE_FORMAT, "FxAccrualRegionUpperBound", path, "");
			})
			.collect(toList());
	}

}
