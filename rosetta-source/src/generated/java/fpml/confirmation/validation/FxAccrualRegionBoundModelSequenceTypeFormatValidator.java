package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualRegionBoundModelSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualRegionBoundModelSequenceTypeFormatValidator implements Validator<FxAccrualRegionBoundModelSequence> {

	private List<ComparisonResult> getComparisonResults(FxAccrualRegionBoundModelSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxAccrualRegionBoundModelSequence> validate(RosettaPath path, FxAccrualRegionBoundModelSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualRegionBoundModelSequence", ValidationType.TYPE_FORMAT, "FxAccrualRegionBoundModelSequence", path, "", error);
		}
		return success("FxAccrualRegionBoundModelSequence", ValidationType.TYPE_FORMAT, "FxAccrualRegionBoundModelSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualRegionBoundModelSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualRegionBoundModelSequence", ValidationType.TYPE_FORMAT, "FxAccrualRegionBoundModelSequence", path, "", res.getError());
				}
				return success("FxAccrualRegionBoundModelSequence", ValidationType.TYPE_FORMAT, "FxAccrualRegionBoundModelSequence", path, "");
			})
			.collect(toList());
	}

}
