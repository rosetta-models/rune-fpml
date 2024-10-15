package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.TradeIdentifierSequence;
import fpml.confirmation.TradeIdentifierSequenceChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeIdentifierSequenceValidator implements Validator<TradeIdentifierSequence> {

	private List<ComparisonResult> getComparisonResults(TradeIdentifierSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyAndAccountReferencesModel", (PartyAndAccountReferencesModel) o.getPartyAndAccountReferencesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradeIdentifierSequenceChoice", (List<? extends TradeIdentifierSequenceChoice>) o.getTradeIdentifierSequenceChoice() == null ? 0 : ((List<? extends TradeIdentifierSequenceChoice>) o.getTradeIdentifierSequenceChoice()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<TradeIdentifierSequence> validate(RosettaPath path, TradeIdentifierSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeIdentifierSequence", ValidationType.CARDINALITY, "TradeIdentifierSequence", path, "", error);
		}
		return success("TradeIdentifierSequence", ValidationType.CARDINALITY, "TradeIdentifierSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeIdentifierSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeIdentifierSequence", ValidationType.CARDINALITY, "TradeIdentifierSequence", path, "", res.getError());
				}
				return success("TradeIdentifierSequence", ValidationType.CARDINALITY, "TradeIdentifierSequence", path, "");
			})
			.collect(toList());
	}

}
