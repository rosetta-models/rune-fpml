package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrAdjustedDate;
import fpml.confirmation.EventPayment;
import fpml.confirmation.EventPaymentSequence;
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

public class EventPaymentValidator implements Validator<EventPayment> {

	private List<ComparisonResult> getComparisonResults(EventPayment o) {
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
				checkCardinality("eventPaymentSequence", (List<? extends EventPaymentSequence>) o.getEventPaymentSequence() == null ? 0 : ((List<? extends EventPaymentSequence>) o.getEventPaymentSequence()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<EventPayment> validate(RosettaPath path, EventPayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EventPayment", ValidationType.CARDINALITY, "EventPayment", path, "", error);
		}
		return success("EventPayment", ValidationType.CARDINALITY, "EventPayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EventPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EventPayment", ValidationType.CARDINALITY, "EventPayment", path, "", res.getError());
				}
				return success("EventPayment", ValidationType.CARDINALITY, "EventPayment", path, "");
			})
			.collect(toList());
	}

}
