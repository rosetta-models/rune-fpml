package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrAdjustedDate;
import fpml.confirmation.LoanAllocationPayment;
import fpml.confirmation.LoanAllocationPaymentSequence;
import fpml.confirmation.Money;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PaymentType;
import fpml.confirmation.SettlementInformation;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanAllocationPaymentValidator implements Validator<LoanAllocationPayment> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationPayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentAmount", (NonNegativeMoney) o.getPaymentAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentDate", (AdjustableOrAdjustedDate) o.getPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentType", (PaymentType) o.getPaymentType() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementInformation", (SettlementInformation) o.getSettlementInformation() != null ? 1 : 0, 0, 1), 
				checkCardinality("discountFactor", (BigDecimal) o.getDiscountFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("presentValueAmount", (Money) o.getPresentValueAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("href", (String) o.getHref() != null ? 1 : 0, 0, 1), 
				checkCardinality("loanAllocationPaymentSequence", (List<? extends LoanAllocationPaymentSequence>) o.getLoanAllocationPaymentSequence() == null ? 0 : ((List<? extends LoanAllocationPaymentSequence>) o.getLoanAllocationPaymentSequence()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<LoanAllocationPayment> validate(RosettaPath path, LoanAllocationPayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanAllocationPayment", ValidationType.CARDINALITY, "LoanAllocationPayment", path, "", error);
		}
		return success("LoanAllocationPayment", ValidationType.CARDINALITY, "LoanAllocationPayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationPayment", ValidationType.CARDINALITY, "LoanAllocationPayment", path, "", res.getError());
				}
				return success("LoanAllocationPayment", ValidationType.CARDINALITY, "LoanAllocationPayment", path, "");
			})
			.collect(toList());
	}

}
