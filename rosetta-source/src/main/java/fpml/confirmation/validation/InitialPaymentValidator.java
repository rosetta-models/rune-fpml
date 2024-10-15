package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InitialPayment;
import fpml.confirmation.Money;
import fpml.confirmation.PayerReceiverModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InitialPaymentValidator implements Validator<InitialPayment> {

	private List<ComparisonResult> getComparisonResults(InitialPayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("adjustablePaymentDate", (Date) o.getAdjustablePaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedPaymentDate", (Date) o.getAdjustedPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentAmount", (Money) o.getPaymentAmount() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<InitialPayment> validate(RosettaPath path, InitialPayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InitialPayment", ValidationType.CARDINALITY, "InitialPayment", path, "", error);
		}
		return success("InitialPayment", ValidationType.CARDINALITY, "InitialPayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InitialPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InitialPayment", ValidationType.CARDINALITY, "InitialPayment", path, "", res.getError());
				}
				return success("InitialPayment", ValidationType.CARDINALITY, "InitialPayment", path, "");
			})
			.collect(toList());
	}

}
