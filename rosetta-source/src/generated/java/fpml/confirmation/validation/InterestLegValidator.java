package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.InterestCalculation;
import fpml.confirmation.InterestLeg;
import fpml.confirmation.InterestLegCalculationPeriodDates;
import fpml.confirmation.LegAmount;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.ReturnSwapNotional;
import fpml.confirmation.StubCalculationPeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InterestLegValidator implements Validator<InterestLeg> {

	private List<ComparisonResult> getComparisonResults(InterestLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminationDate", (AdjustableOrRelativeDate) o.getTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("interestLegCalculationPeriodDates", (InterestLegCalculationPeriodDates) o.getInterestLegCalculationPeriodDates() != null ? 1 : 0, 1, 1), 
				checkCardinality("notional", (ReturnSwapNotional) o.getNotional() != null ? 1 : 0, 1, 1), 
				checkCardinality("interestAmount", (LegAmount) o.getInterestAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("interestCalculation", (InterestCalculation) o.getInterestCalculation() != null ? 1 : 0, 1, 1), 
				checkCardinality("stubCalculationPeriod", (StubCalculationPeriod) o.getStubCalculationPeriod() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<InterestLeg> validate(RosettaPath path, InterestLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InterestLeg", ValidationType.CARDINALITY, "InterestLeg", path, "", error);
		}
		return success("InterestLeg", ValidationType.CARDINALITY, "InterestLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestLeg", ValidationType.CARDINALITY, "InterestLeg", path, "", res.getError());
				}
				return success("InterestLeg", ValidationType.CARDINALITY, "InterestLeg", path, "");
			})
			.collect(toList());
	}

}
