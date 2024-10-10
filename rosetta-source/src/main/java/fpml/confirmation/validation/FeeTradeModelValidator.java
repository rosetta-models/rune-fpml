package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FeeTradeModel;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.Trade;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FeeTradeModelValidator implements Validator<FeeTradeModel> {

	private List<ComparisonResult> getComparisonResults(FeeTradeModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("feeTradeIdentifier", (PartyTradeIdentifier) o.getFeeTradeIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("feeTrade", (Trade) o.getFeeTrade() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FeeTradeModel> validate(RosettaPath path, FeeTradeModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FeeTradeModel", ValidationType.CARDINALITY, "FeeTradeModel", path, "", error);
		}
		return success("FeeTradeModel", ValidationType.CARDINALITY, "FeeTradeModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FeeTradeModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FeeTradeModel", ValidationType.CARDINALITY, "FeeTradeModel", path, "", res.getError());
				}
				return success("FeeTradeModel", ValidationType.CARDINALITY, "FeeTradeModel", path, "");
			})
			.collect(toList());
	}

}
