package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.VarianceAmount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VarianceAmountTypeFormatValidator implements Validator<VarianceAmount> {

	private List<ComparisonResult> getComparisonResults(VarianceAmount o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<VarianceAmount> validate(RosettaPath path, VarianceAmount o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VarianceAmount", ValidationType.TYPE_FORMAT, "VarianceAmount", path, "", error);
		}
		return success("VarianceAmount", ValidationType.TYPE_FORMAT, "VarianceAmount", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VarianceAmount", ValidationType.TYPE_FORMAT, "VarianceAmount", path, "", res.getError());
				}
				return success("VarianceAmount", ValidationType.TYPE_FORMAT, "VarianceAmount", path, "");
			})
			.collect(toList());
	}

}
