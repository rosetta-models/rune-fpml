package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanTradeSettlementTask;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradeSettlementTaskTypeFormatValidator implements Validator<LoanTradeSettlementTask> {

	private List<ComparisonResult> getComparisonResults(LoanTradeSettlementTask o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("comment", o.getComment(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<LoanTradeSettlementTask> validate(RosettaPath path, LoanTradeSettlementTask o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradeSettlementTask", ValidationType.TYPE_FORMAT, "LoanTradeSettlementTask", path, "", error);
		}
		return success("LoanTradeSettlementTask", ValidationType.TYPE_FORMAT, "LoanTradeSettlementTask", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradeSettlementTask o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradeSettlementTask", ValidationType.TYPE_FORMAT, "LoanTradeSettlementTask", path, "", res.getError());
				}
				return success("LoanTradeSettlementTask", ValidationType.TYPE_FORMAT, "LoanTradeSettlementTask", path, "");
			})
			.collect(toList());
	}

}
