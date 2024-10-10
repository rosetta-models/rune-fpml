package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CalculationPeriodAmount;
import fpml.confirmation.CalculationPeriodDates;
import fpml.confirmation.Cashflows;
import fpml.confirmation.Formula;
import fpml.confirmation.InterestRateStream;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PaymentDates;
import fpml.confirmation.PrincipalExchanges;
import fpml.confirmation.ResetDates;
import fpml.confirmation.SettlementProvision;
import fpml.confirmation.StubCalculationPeriodAmount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InterestRateStreamValidator implements Validator<InterestRateStream> {

	private List<ComparisonResult> getComparisonResults(InterestRateStream o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("calculationPeriodDates", (CalculationPeriodDates) o.getCalculationPeriodDates() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentDates", (PaymentDates) o.getPaymentDates() != null ? 1 : 0, 1, 1), 
				checkCardinality("resetDates", (ResetDates) o.getResetDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodAmount", (CalculationPeriodAmount) o.getCalculationPeriodAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("stubCalculationPeriodAmount", (StubCalculationPeriodAmount) o.getStubCalculationPeriodAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("principalExchanges", (PrincipalExchanges) o.getPrincipalExchanges() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashflows", (Cashflows) o.getCashflows() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementProvision", (SettlementProvision) o.getSettlementProvision() != null ? 1 : 0, 0, 1), 
				checkCardinality("formula", (Formula) o.getFormula() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<InterestRateStream> validate(RosettaPath path, InterestRateStream o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InterestRateStream", ValidationType.CARDINALITY, "InterestRateStream", path, "", error);
		}
		return success("InterestRateStream", ValidationType.CARDINALITY, "InterestRateStream", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestRateStream o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestRateStream", ValidationType.CARDINALITY, "InterestRateStream", path, "", res.getError());
				}
				return success("InterestRateStream", ValidationType.CARDINALITY, "InterestRateStream", path, "");
			})
			.collect(toList());
	}

}
