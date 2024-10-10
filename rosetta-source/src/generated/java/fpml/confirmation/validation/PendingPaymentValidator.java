package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Money;
import fpml.confirmation.PendingPayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PendingPaymentValidator implements Validator<PendingPayment> {

	private List<ComparisonResult> getComparisonResults(PendingPayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentDate", (Date) o.getPaymentDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("amount", (Money) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("accruedInterest", (Money) o.getAccruedInterest() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PendingPayment> validate(RosettaPath path, PendingPayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PendingPayment", ValidationType.CARDINALITY, "PendingPayment", path, "", error);
		}
		return success("PendingPayment", ValidationType.CARDINALITY, "PendingPayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PendingPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PendingPayment", ValidationType.CARDINALITY, "PendingPayment", path, "", res.getError());
				}
				return success("PendingPayment", ValidationType.CARDINALITY, "PendingPayment", path, "");
			})
			.collect(toList());
	}

}
