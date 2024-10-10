package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.WithdrawalSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class WithdrawalSequenceValidator implements Validator<WithdrawalSequence> {

	private List<ComparisonResult> getComparisonResults(WithdrawalSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyTradeIdentifier", (List<? extends PartyTradeIdentifier>) o.getPartyTradeIdentifier() == null ? 0 : ((List<? extends PartyTradeIdentifier>) o.getPartyTradeIdentifier()).size(), 1, 0)
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
			return failure("WithdrawalSequence", ValidationType.CARDINALITY, "WithdrawalSequence", path, "", error);
		}
		return success("WithdrawalSequence", ValidationType.CARDINALITY, "WithdrawalSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WithdrawalSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WithdrawalSequence", ValidationType.CARDINALITY, "WithdrawalSequence", path, "", res.getError());
				}
				return success("WithdrawalSequence", ValidationType.CARDINALITY, "WithdrawalSequence", path, "");
			})
			.collect(toList());
	}

}
