package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CalculationAmount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CalculationAmountTypeFormatValidator implements Validator<CalculationAmount> {

	private List<ComparisonResult> getComparisonResults(CalculationAmount o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CalculationAmount> validate(RosettaPath path, CalculationAmount o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CalculationAmount", ValidationType.TYPE_FORMAT, "CalculationAmount", path, "", error);
		}
		return success("CalculationAmount", ValidationType.TYPE_FORMAT, "CalculationAmount", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationAmount", ValidationType.TYPE_FORMAT, "CalculationAmount", path, "", res.getError());
				}
				return success("CalculationAmount", ValidationType.TYPE_FORMAT, "CalculationAmount", path, "");
			})
			.collect(toList());
	}

}
