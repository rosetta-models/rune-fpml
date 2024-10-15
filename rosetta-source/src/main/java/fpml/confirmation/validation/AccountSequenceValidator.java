package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccountSequence;
import fpml.confirmation.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AccountSequenceValidator implements Validator<AccountSequence> {

	private List<ComparisonResult> getComparisonResults(AccountSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("accountBeneficiary", (PartyReference) o.getAccountBeneficiary() != null ? 1 : 0, 1, 1), 
				checkCardinality("servicingParty", (PartyReference) o.getServicingParty() != null ? 1 : 0, 0, 1)
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
			return failure("AccountSequence", ValidationType.CARDINALITY, "AccountSequence", path, "", error);
		}
		return success("AccountSequence", ValidationType.CARDINALITY, "AccountSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccountSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AccountSequence", ValidationType.CARDINALITY, "AccountSequence", path, "", res.getError());
				}
				return success("AccountSequence", ValidationType.CARDINALITY, "AccountSequence", path, "");
			})
			.collect(toList());
	}

}
