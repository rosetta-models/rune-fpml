package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanNotificationExceptionSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanNotificationExceptionSequenceTypeFormatValidator implements Validator<LoanNotificationExceptionSequence> {

	private List<ComparisonResult> getComparisonResults(LoanNotificationExceptionSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LoanNotificationExceptionSequence> validate(RosettaPath path, LoanNotificationExceptionSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanNotificationExceptionSequence", ValidationType.TYPE_FORMAT, "LoanNotificationExceptionSequence", path, "", error);
		}
		return success("LoanNotificationExceptionSequence", ValidationType.TYPE_FORMAT, "LoanNotificationExceptionSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanNotificationExceptionSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanNotificationExceptionSequence", ValidationType.TYPE_FORMAT, "LoanNotificationExceptionSequence", path, "", res.getError());
				}
				return success("LoanNotificationExceptionSequence", ValidationType.TYPE_FORMAT, "LoanNotificationExceptionSequence", path, "");
			})
			.collect(toList());
	}

}
