package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AmountSchedule;
import fpml.confirmation.Calculation;
import fpml.confirmation.CalculationPeriodAmount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CalculationPeriodAmountValidator implements Validator<CalculationPeriodAmount> {

	private List<ComparisonResult> getComparisonResults(CalculationPeriodAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculation", (Calculation) o.getCalculation() != null ? 1 : 0, 0, 1), 
				checkCardinality("knownAmountSchedule", (AmountSchedule) o.getKnownAmountSchedule() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CalculationPeriodAmount> validate(RosettaPath path, CalculationPeriodAmount o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CalculationPeriodAmount", ValidationType.CARDINALITY, "CalculationPeriodAmount", path, "", error);
		}
		return success("CalculationPeriodAmount", ValidationType.CARDINALITY, "CalculationPeriodAmount", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationPeriodAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationPeriodAmount", ValidationType.CARDINALITY, "CalculationPeriodAmount", path, "", res.getError());
				}
				return success("CalculationPeriodAmount", ValidationType.CARDINALITY, "CalculationPeriodAmount", path, "");
			})
			.collect(toList());
	}

}
