package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Account;
import fpml.confirmation.AccountId;
import fpml.confirmation.AccountName;
import fpml.confirmation.AccountSequence;
import fpml.confirmation.AccountType;
import fpml.confirmation.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AccountValidator implements Validator<Account> {

	private List<ComparisonResult> getComparisonResults(Account o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("accountId", (List<? extends AccountId>) o.getAccountId() == null ? 0 : ((List<? extends AccountId>) o.getAccountId()).size(), 1, 0), 
				checkCardinality("accountName", (AccountName) o.getAccountName() != null ? 1 : 0, 0, 1), 
				checkCardinality("accountType", (AccountType) o.getAccountType() != null ? 1 : 0, 0, 1), 
				checkCardinality("accountSequence", (AccountSequence) o.getAccountSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("servicingParty", (PartyReference) o.getServicingParty() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<Account> validate(RosettaPath path, Account o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Account", ValidationType.CARDINALITY, "Account", path, "", error);
		}
		return success("Account", ValidationType.CARDINALITY, "Account", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Account o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Account", ValidationType.CARDINALITY, "Account", path, "", res.getError());
				}
				return success("Account", ValidationType.CARDINALITY, "Account", path, "");
			})
			.collect(toList());
	}

}
