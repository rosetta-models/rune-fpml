package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualRegionSequence0;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualRegionSequence0TypeFormatValidator implements Validator<FxAccrualRegionSequence0> {

	private List<ComparisonResult> getComparisonResults(FxAccrualRegionSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxAccrualRegionSequence0> validate(RosettaPath path, FxAccrualRegionSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualRegionSequence0", ValidationType.TYPE_FORMAT, "FxAccrualRegionSequence0", path, "", error);
		}
		return success("FxAccrualRegionSequence0", ValidationType.TYPE_FORMAT, "FxAccrualRegionSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualRegionSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualRegionSequence0", ValidationType.TYPE_FORMAT, "FxAccrualRegionSequence0", path, "", res.getError());
				}
				return success("FxAccrualRegionSequence0", ValidationType.TYPE_FORMAT, "FxAccrualRegionSequence0", path, "");
			})
			.collect(toList());
	}

}
