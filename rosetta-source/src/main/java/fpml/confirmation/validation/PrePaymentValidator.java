package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PrePayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PrePaymentValidator implements Validator<PrePayment> {

	private List<ComparisonResult> getComparisonResults(PrePayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("prePayment", (Boolean) o.getPrePayment() != null ? 1 : 0, 1, 1), 
				checkCardinality("prePaymentAmount", (NonNegativeMoney) o.getPrePaymentAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("prePaymentDate", (AdjustableDate) o.getPrePaymentDate() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<PrePayment> validate(RosettaPath path, PrePayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PrePayment", ValidationType.CARDINALITY, "PrePayment", path, "", error);
		}
		return success("PrePayment", ValidationType.CARDINALITY, "PrePayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrePayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrePayment", ValidationType.CARDINALITY, "PrePayment", path, "", res.getError());
				}
				return success("PrePayment", ValidationType.CARDINALITY, "PrePayment", path, "");
			})
			.collect(toList());
	}

}
