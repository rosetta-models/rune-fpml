package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanTradePayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradePaymentTypeFormatValidator implements Validator<LoanTradePayment> {

	private List<ComparisonResult> getComparisonResults(LoanTradePayment o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LoanTradePayment> validate(RosettaPath path, LoanTradePayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradePayment", ValidationType.TYPE_FORMAT, "LoanTradePayment", path, "", error);
		}
		return success("LoanTradePayment", ValidationType.TYPE_FORMAT, "LoanTradePayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradePayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradePayment", ValidationType.TYPE_FORMAT, "LoanTradePayment", path, "", res.getError());
				}
				return success("LoanTradePayment", ValidationType.TYPE_FORMAT, "LoanTradePayment", path, "");
			})
			.collect(toList());
	}

}
