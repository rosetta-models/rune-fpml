package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CashflowId;
import fpml.confirmation.GrossCashflowSequence;
import fpml.confirmation.Money;
import fpml.confirmation.PartyTradeIdentifierReference;
import fpml.confirmation.PayerReceiverModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GrossCashflowSequenceValidator implements Validator<GrossCashflowSequence> {

	private List<ComparisonResult> getComparisonResults(GrossCashflowSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cashflowId", (CashflowId) o.getCashflowId() != null ? 1 : 0, 1, 1), 
				checkCardinality("partyTradeIdentifierReference", (PartyTradeIdentifierReference) o.getPartyTradeIdentifierReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("cashflowAmount", (Money) o.getCashflowAmount() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<GrossCashflowSequence> validate(RosettaPath path, GrossCashflowSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GrossCashflowSequence", ValidationType.CARDINALITY, "GrossCashflowSequence", path, "", error);
		}
		return success("GrossCashflowSequence", ValidationType.CARDINALITY, "GrossCashflowSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GrossCashflowSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GrossCashflowSequence", ValidationType.CARDINALITY, "GrossCashflowSequence", path, "", res.getError());
				}
				return success("GrossCashflowSequence", ValidationType.CARDINALITY, "GrossCashflowSequence", path, "");
			})
			.collect(toList());
	}

}
