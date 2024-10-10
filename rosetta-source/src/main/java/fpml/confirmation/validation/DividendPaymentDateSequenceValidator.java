package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DividendDateReferenceEnum;
import fpml.confirmation.DividendPaymentDateSequence;
import fpml.confirmation.Offset;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DividendPaymentDateSequenceValidator implements Validator<DividendPaymentDateSequence> {

	private List<ComparisonResult> getComparisonResults(DividendPaymentDateSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dividendDateReference", (DividendDateReferenceEnum) o.getDividendDateReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentDateOffset", (Offset) o.getPaymentDateOffset() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<DividendPaymentDateSequence> validate(RosettaPath path, DividendPaymentDateSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DividendPaymentDateSequence", ValidationType.CARDINALITY, "DividendPaymentDateSequence", path, "", error);
		}
		return success("DividendPaymentDateSequence", ValidationType.CARDINALITY, "DividendPaymentDateSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPaymentDateSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendPaymentDateSequence", ValidationType.CARDINALITY, "DividendPaymentDateSequence", path, "", res.getError());
				}
				return success("DividendPaymentDateSequence", ValidationType.CARDINALITY, "DividendPaymentDateSequence", path, "");
			})
			.collect(toList());
	}

}
