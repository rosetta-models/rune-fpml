package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualLinearPayoffRegion;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualLinearPayoffRegionTypeFormatValidator implements Validator<FxAccrualLinearPayoffRegion> {

	private List<ComparisonResult> getComparisonResults(FxAccrualLinearPayoffRegion o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxAccrualLinearPayoffRegion> validate(RosettaPath path, FxAccrualLinearPayoffRegion o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualLinearPayoffRegion", ValidationType.TYPE_FORMAT, "FxAccrualLinearPayoffRegion", path, "", error);
		}
		return success("FxAccrualLinearPayoffRegion", ValidationType.TYPE_FORMAT, "FxAccrualLinearPayoffRegion", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualLinearPayoffRegion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualLinearPayoffRegion", ValidationType.TYPE_FORMAT, "FxAccrualLinearPayoffRegion", path, "", res.getError());
				}
				return success("FxAccrualLinearPayoffRegion", ValidationType.TYPE_FORMAT, "FxAccrualLinearPayoffRegion", path, "");
			})
			.collect(toList());
	}

}
