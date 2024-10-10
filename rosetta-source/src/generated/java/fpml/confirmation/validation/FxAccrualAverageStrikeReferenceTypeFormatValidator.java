package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualAverageStrikeReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualAverageStrikeReferenceTypeFormatValidator implements Validator<FxAccrualAverageStrikeReference> {

	private List<ComparisonResult> getComparisonResults(FxAccrualAverageStrikeReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxAccrualAverageStrikeReference> validate(RosettaPath path, FxAccrualAverageStrikeReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualAverageStrikeReference", ValidationType.TYPE_FORMAT, "FxAccrualAverageStrikeReference", path, "", error);
		}
		return success("FxAccrualAverageStrikeReference", ValidationType.TYPE_FORMAT, "FxAccrualAverageStrikeReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualAverageStrikeReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualAverageStrikeReference", ValidationType.TYPE_FORMAT, "FxAccrualAverageStrikeReference", path, "", res.getError());
				}
				return success("FxAccrualAverageStrikeReference", ValidationType.TYPE_FORMAT, "FxAccrualAverageStrikeReference", path, "");
			})
			.collect(toList());
	}

}
