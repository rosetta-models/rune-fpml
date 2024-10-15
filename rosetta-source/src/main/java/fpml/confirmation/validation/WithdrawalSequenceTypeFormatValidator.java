package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.WithdrawalSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class WithdrawalSequenceTypeFormatValidator implements Validator<WithdrawalSequence> {

	private List<ComparisonResult> getComparisonResults(WithdrawalSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<WithdrawalSequence> validate(RosettaPath path, WithdrawalSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("WithdrawalSequence", ValidationType.TYPE_FORMAT, "WithdrawalSequence", path, "", error);
		}
		return success("WithdrawalSequence", ValidationType.TYPE_FORMAT, "WithdrawalSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WithdrawalSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WithdrawalSequence", ValidationType.TYPE_FORMAT, "WithdrawalSequence", path, "", res.getError());
				}
				return success("WithdrawalSequence", ValidationType.TYPE_FORMAT, "WithdrawalSequence", path, "");
			})
			.collect(toList());
	}

}
