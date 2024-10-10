package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanTransferFee;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTransferFeeTypeFormatValidator implements Validator<LoanTransferFee> {

	private List<ComparisonResult> getComparisonResults(LoanTransferFee o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LoanTransferFee> validate(RosettaPath path, LoanTransferFee o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTransferFee", ValidationType.TYPE_FORMAT, "LoanTransferFee", path, "", error);
		}
		return success("LoanTransferFee", ValidationType.TYPE_FORMAT, "LoanTransferFee", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTransferFee o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTransferFee", ValidationType.TYPE_FORMAT, "LoanTransferFee", path, "", res.getError());
				}
				return success("LoanTransferFee", ValidationType.TYPE_FORMAT, "LoanTransferFee", path, "");
			})
			.collect(toList());
	}

}
