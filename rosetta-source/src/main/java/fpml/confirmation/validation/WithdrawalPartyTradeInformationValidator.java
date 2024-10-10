package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.WithdrawalPartyTradeInformation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class WithdrawalPartyTradeInformationValidator implements Validator<WithdrawalPartyTradeInformation> {

	private List<ComparisonResult> getComparisonResults(WithdrawalPartyTradeInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyAndAccountReferencesModel", (PartyAndAccountReferencesModel) o.getPartyAndAccountReferencesModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<WithdrawalPartyTradeInformation> validate(RosettaPath path, WithdrawalPartyTradeInformation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("WithdrawalPartyTradeInformation", ValidationType.CARDINALITY, "WithdrawalPartyTradeInformation", path, "", error);
		}
		return success("WithdrawalPartyTradeInformation", ValidationType.CARDINALITY, "WithdrawalPartyTradeInformation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WithdrawalPartyTradeInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WithdrawalPartyTradeInformation", ValidationType.CARDINALITY, "WithdrawalPartyTradeInformation", path, "", res.getError());
				}
				return success("WithdrawalPartyTradeInformation", ValidationType.CARDINALITY, "WithdrawalPartyTradeInformation", path, "");
			})
			.collect(toList());
	}

}
