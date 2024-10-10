package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IndependentAmount;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PaymentDetail;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class IndependentAmountValidator implements Validator<IndependentAmount> {

	private List<ComparisonResult> getComparisonResults(IndependentAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentDetail", (List<? extends PaymentDetail>) o.getPaymentDetail() == null ? 0 : ((List<? extends PaymentDetail>) o.getPaymentDetail()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<IndependentAmount> validate(RosettaPath path, IndependentAmount o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("IndependentAmount", ValidationType.CARDINALITY, "IndependentAmount", path, "", error);
		}
		return success("IndependentAmount", ValidationType.CARDINALITY, "IndependentAmount", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IndependentAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IndependentAmount", ValidationType.CARDINALITY, "IndependentAmount", path, "", res.getError());
				}
				return success("IndependentAmount", ValidationType.CARDINALITY, "IndependentAmount", path, "");
			})
			.collect(toList());
	}

}
