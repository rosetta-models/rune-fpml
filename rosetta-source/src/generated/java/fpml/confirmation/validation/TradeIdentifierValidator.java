package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IssuerTradeIdModel;
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.TradeIdentifierSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeIdentifierValidator implements Validator<TradeIdentifier> {

	private List<ComparisonResult> getComparisonResults(TradeIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("issuerTradeIdModel", (IssuerTradeIdModel) o.getIssuerTradeIdModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradeIdentifierSequence", (TradeIdentifierSequence) o.getTradeIdentifierSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TradeIdentifier> validate(RosettaPath path, TradeIdentifier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeIdentifier", ValidationType.CARDINALITY, "TradeIdentifier", path, "", error);
		}
		return success("TradeIdentifier", ValidationType.CARDINALITY, "TradeIdentifier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeIdentifier", ValidationType.CARDINALITY, "TradeIdentifier", path, "", res.getError());
				}
				return success("TradeIdentifier", ValidationType.CARDINALITY, "TradeIdentifier", path, "");
			})
			.collect(toList());
	}

}
