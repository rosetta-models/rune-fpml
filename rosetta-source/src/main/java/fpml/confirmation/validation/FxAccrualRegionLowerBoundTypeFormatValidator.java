package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualRegionLowerBound;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualRegionLowerBoundTypeFormatValidator implements Validator<FxAccrualRegionLowerBound> {

	private List<ComparisonResult> getComparisonResults(FxAccrualRegionLowerBound o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxAccrualRegionLowerBound> validate(RosettaPath path, FxAccrualRegionLowerBound o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualRegionLowerBound", ValidationType.TYPE_FORMAT, "FxAccrualRegionLowerBound", path, "", error);
		}
		return success("FxAccrualRegionLowerBound", ValidationType.TYPE_FORMAT, "FxAccrualRegionLowerBound", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualRegionLowerBound o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualRegionLowerBound", ValidationType.TYPE_FORMAT, "FxAccrualRegionLowerBound", path, "", res.getError());
				}
				return success("FxAccrualRegionLowerBound", ValidationType.TYPE_FORMAT, "FxAccrualRegionLowerBound", path, "");
			})
			.collect(toList());
	}

}
