package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.PaymentProjection;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PaymentProjectionValidator implements Validator<PaymentProjection> {

	private List<ComparisonResult> getComparisonResults(PaymentProjection o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("nextPaymentDate", (Date) o.getNextPaymentDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("projectedAmount", (MoneyWithParticipantShare) o.getProjectedAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PaymentProjection> validate(RosettaPath path, PaymentProjection o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PaymentProjection", ValidationType.CARDINALITY, "PaymentProjection", path, "", error);
		}
		return success("PaymentProjection", ValidationType.CARDINALITY, "PaymentProjection", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentProjection o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PaymentProjection", ValidationType.CARDINALITY, "PaymentProjection", path, "", res.getError());
				}
				return success("PaymentProjection", ValidationType.CARDINALITY, "PaymentProjection", path, "");
			})
			.collect(toList());
	}

}
