package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Compounding;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FloatingRateCalculation;
import fpml.confirmation.InterestCalculation;
import fpml.confirmation.InterestCalculationSequence;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InterestCalculationValidator implements Validator<InterestCalculation> {

	private List<ComparisonResult> getComparisonResults(InterestCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("floatingRateCalculation", (FloatingRateCalculation) o.getFloatingRateCalculation() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedRate", (BigDecimal) o.getFixedRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 1, 1), 
				checkCardinality("compounding", (Compounding) o.getCompounding() != null ? 1 : 0, 0, 1), 
				checkCardinality("interestCalculationSequence", (InterestCalculationSequence) o.getInterestCalculationSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<InterestCalculation> validate(RosettaPath path, InterestCalculation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InterestCalculation", ValidationType.CARDINALITY, "InterestCalculation", path, "", error);
		}
		return success("InterestCalculation", ValidationType.CARDINALITY, "InterestCalculation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestCalculation", ValidationType.CARDINALITY, "InterestCalculation", path, "", res.getError());
				}
				return success("InterestCalculation", ValidationType.CARDINALITY, "InterestCalculation", path, "");
			})
			.collect(toList());
	}

}
