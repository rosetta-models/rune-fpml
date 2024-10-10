package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualPayoffRegion;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualPayoffRegionTypeFormatValidator implements Validator<FxAccrualPayoffRegion> {

	private List<ComparisonResult> getComparisonResults(FxAccrualPayoffRegion o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxAccrualPayoffRegion> validate(RosettaPath path, FxAccrualPayoffRegion o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualPayoffRegion", ValidationType.TYPE_FORMAT, "FxAccrualPayoffRegion", path, "", error);
		}
		return success("FxAccrualPayoffRegion", ValidationType.TYPE_FORMAT, "FxAccrualPayoffRegion", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualPayoffRegion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualPayoffRegion", ValidationType.TYPE_FORMAT, "FxAccrualPayoffRegion", path, "", res.getError());
				}
				return success("FxAccrualPayoffRegion", ValidationType.TYPE_FORMAT, "FxAccrualPayoffRegion", path, "");
			})
			.collect(toList());
	}

}
