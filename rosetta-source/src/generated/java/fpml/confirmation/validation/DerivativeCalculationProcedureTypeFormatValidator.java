package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DerivativeCalculationProcedure;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DerivativeCalculationProcedureTypeFormatValidator implements Validator<DerivativeCalculationProcedure> {

	private List<ComparisonResult> getComparisonResults(DerivativeCalculationProcedure o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<DerivativeCalculationProcedure> validate(RosettaPath path, DerivativeCalculationProcedure o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DerivativeCalculationProcedure", ValidationType.TYPE_FORMAT, "DerivativeCalculationProcedure", path, "", error);
		}
		return success("DerivativeCalculationProcedure", ValidationType.TYPE_FORMAT, "DerivativeCalculationProcedure", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DerivativeCalculationProcedure o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DerivativeCalculationProcedure", ValidationType.TYPE_FORMAT, "DerivativeCalculationProcedure", path, "", res.getError());
				}
				return success("DerivativeCalculationProcedure", ValidationType.TYPE_FORMAT, "DerivativeCalculationProcedure", path, "");
			})
			.collect(toList());
	}

}
