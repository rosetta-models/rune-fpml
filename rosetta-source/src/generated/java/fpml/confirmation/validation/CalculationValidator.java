package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Calculation;
import fpml.confirmation.CalculationSequence;
import fpml.confirmation.CompoundingMethodEnum;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.Discounting;
import fpml.confirmation.FxLinkedNotionalSchedule;
import fpml.confirmation.Notional;
import fpml.confirmation.Rate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CalculationValidator implements Validator<Calculation> {

	private List<ComparisonResult> getComparisonResults(Calculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("notionalSchedule", (Notional) o.getNotionalSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxLinkedNotionalSchedule", (FxLinkedNotionalSchedule) o.getFxLinkedNotionalSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationSequence", (CalculationSequence) o.getCalculationSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateCalculation", (Rate) o.getRateCalculation() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 1, 1), 
				checkCardinality("discounting", (Discounting) o.getDiscounting() != null ? 1 : 0, 0, 1), 
				checkCardinality("compoundingMethod", (CompoundingMethodEnum) o.getCompoundingMethod() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Calculation> validate(RosettaPath path, Calculation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Calculation", ValidationType.CARDINALITY, "Calculation", path, "", error);
		}
		return success("Calculation", ValidationType.CARDINALITY, "Calculation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Calculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Calculation", ValidationType.CARDINALITY, "Calculation", path, "", res.getError());
				}
				return success("Calculation", ValidationType.CARDINALITY, "Calculation", path, "");
			})
			.collect(toList());
	}

}
