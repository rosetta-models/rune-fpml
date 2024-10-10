package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IssuerTradeIdModel;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.TradeIdentifierSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyTradeIdentifierValidator implements Validator<PartyTradeIdentifier> {

	private List<ComparisonResult> getComparisonResults(PartyTradeIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("issuerTradeIdModel", (IssuerTradeIdModel) o.getIssuerTradeIdModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeIdentifierSequence", (TradeIdentifierSequence) o.getTradeIdentifierSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("blockTradeId", (TradeIdentifier) o.getBlockTradeId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PartyTradeIdentifier> validate(RosettaPath path, PartyTradeIdentifier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyTradeIdentifier", ValidationType.CARDINALITY, "PartyTradeIdentifier", path, "", error);
		}
		return success("PartyTradeIdentifier", ValidationType.CARDINALITY, "PartyTradeIdentifier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyTradeIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyTradeIdentifier", ValidationType.CARDINALITY, "PartyTradeIdentifier", path, "", res.getError());
				}
				return success("PartyTradeIdentifier", ValidationType.CARDINALITY, "PartyTradeIdentifier", path, "");
			})
			.collect(toList());
	}

}
