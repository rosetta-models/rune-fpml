package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccountSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AccountSequenceTypeFormatValidator implements Validator<AccountSequence> {

	private List<ComparisonResult> getComparisonResults(AccountSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<AccountSequence> validate(RosettaPath path, AccountSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AccountSequence", ValidationType.TYPE_FORMAT, "AccountSequence", path, "", error);
		}
		return success("AccountSequence", ValidationType.TYPE_FORMAT, "AccountSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccountSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AccountSequence", ValidationType.TYPE_FORMAT, "AccountSequence", path, "", res.getError());
				}
				return success("AccountSequence", ValidationType.TYPE_FORMAT, "AccountSequence", path, "");
			})
			.collect(toList());
	}

}
