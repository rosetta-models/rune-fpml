package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.FixedPaymentAmount;
import fpml.confirmation.FixedPaymentLeg;
import fpml.confirmation.PayerReceiverModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FixedPaymentLegValidator implements Validator<FixedPaymentLeg> {

	private List<ComparisonResult> getComparisonResults(FixedPaymentLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminationDate", (AdjustableOrRelativeDate) o.getTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedPayment", (List<? extends FixedPaymentAmount>) o.getFixedPayment() == null ? 0 : ((List<? extends FixedPaymentAmount>) o.getFixedPayment()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<FixedPaymentLeg> validate(RosettaPath path, FixedPaymentLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FixedPaymentLeg", ValidationType.CARDINALITY, "FixedPaymentLeg", path, "", error);
		}
		return success("FixedPaymentLeg", ValidationType.CARDINALITY, "FixedPaymentLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedPaymentLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedPaymentLeg", ValidationType.CARDINALITY, "FixedPaymentLeg", path, "", res.getError());
				}
				return success("FixedPaymentLeg", ValidationType.CARDINALITY, "FixedPaymentLeg", path, "");
			})
			.collect(toList());
	}

}
