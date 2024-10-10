package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PrioritizedRateSourceModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PrioritizedRateSourceModelTypeFormatValidator implements Validator<PrioritizedRateSourceModel> {

	private List<ComparisonResult> getComparisonResults(PrioritizedRateSourceModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PrioritizedRateSourceModel> validate(RosettaPath path, PrioritizedRateSourceModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PrioritizedRateSourceModel", ValidationType.TYPE_FORMAT, "PrioritizedRateSourceModel", path, "", error);
		}
		return success("PrioritizedRateSourceModel", ValidationType.TYPE_FORMAT, "PrioritizedRateSourceModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrioritizedRateSourceModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrioritizedRateSourceModel", ValidationType.TYPE_FORMAT, "PrioritizedRateSourceModel", path, "", res.getError());
				}
				return success("PrioritizedRateSourceModel", ValidationType.TYPE_FORMAT, "PrioritizedRateSourceModel", path, "");
			})
			.collect(toList());
	}

}
