package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualRegion;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualRegionTypeFormatValidator implements Validator<FxAccrualRegion> {

	private List<ComparisonResult> getComparisonResults(FxAccrualRegion o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxAccrualRegion> validate(RosettaPath path, FxAccrualRegion o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualRegion", ValidationType.TYPE_FORMAT, "FxAccrualRegion", path, "", error);
		}
		return success("FxAccrualRegion", ValidationType.TYPE_FORMAT, "FxAccrualRegion", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualRegion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualRegion", ValidationType.TYPE_FORMAT, "FxAccrualRegion", path, "", res.getError());
				}
				return success("FxAccrualRegion", ValidationType.TYPE_FORMAT, "FxAccrualRegion", path, "");
			})
			.collect(toList());
	}

}
