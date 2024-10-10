package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualRegionSequence1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualRegionSequence1TypeFormatValidator implements Validator<FxAccrualRegionSequence1> {

	private List<ComparisonResult> getComparisonResults(FxAccrualRegionSequence1 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxAccrualRegionSequence1> validate(RosettaPath path, FxAccrualRegionSequence1 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualRegionSequence1", ValidationType.TYPE_FORMAT, "FxAccrualRegionSequence1", path, "", error);
		}
		return success("FxAccrualRegionSequence1", ValidationType.TYPE_FORMAT, "FxAccrualRegionSequence1", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualRegionSequence1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualRegionSequence1", ValidationType.TYPE_FORMAT, "FxAccrualRegionSequence1", path, "", res.getError());
				}
				return success("FxAccrualRegionSequence1", ValidationType.TYPE_FORMAT, "FxAccrualRegionSequence1", path, "");
			})
			.collect(toList());
	}

}
