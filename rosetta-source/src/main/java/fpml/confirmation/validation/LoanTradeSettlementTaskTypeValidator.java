package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanTradeSettlementTaskType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradeSettlementTaskTypeValidator implements Validator<LoanTradeSettlementTaskType> {

	private List<ComparisonResult> getComparisonResults(LoanTradeSettlementTaskType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradeSettlementTaskTypeScheme", (String) o.getTradeSettlementTaskTypeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LoanTradeSettlementTaskType> validate(RosettaPath path, LoanTradeSettlementTaskType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradeSettlementTaskType", ValidationType.CARDINALITY, "LoanTradeSettlementTaskType", path, "", error);
		}
		return success("LoanTradeSettlementTaskType", ValidationType.CARDINALITY, "LoanTradeSettlementTaskType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradeSettlementTaskType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradeSettlementTaskType", ValidationType.CARDINALITY, "LoanTradeSettlementTaskType", path, "", res.getError());
				}
				return success("LoanTradeSettlementTaskType", ValidationType.CARDINALITY, "LoanTradeSettlementTaskType", path, "");
			})
			.collect(toList());
	}

}
