package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanInterestPaymentSequence;
import fpml.confirmation.PaymentProjection;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanInterestPaymentSequenceValidator implements Validator<LoanInterestPaymentSequence> {

	private List<ComparisonResult> getComparisonResults(LoanInterestPaymentSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("projection", (PaymentProjection) o.getProjection() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LoanInterestPaymentSequence> validate(RosettaPath path, LoanInterestPaymentSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanInterestPaymentSequence", ValidationType.CARDINALITY, "LoanInterestPaymentSequence", path, "", error);
		}
		return success("LoanInterestPaymentSequence", ValidationType.CARDINALITY, "LoanInterestPaymentSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanInterestPaymentSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanInterestPaymentSequence", ValidationType.CARDINALITY, "LoanInterestPaymentSequence", path, "", res.getError());
				}
				return success("LoanInterestPaymentSequence", ValidationType.CARDINALITY, "LoanInterestPaymentSequence", path, "");
			})
			.collect(toList());
	}

}
