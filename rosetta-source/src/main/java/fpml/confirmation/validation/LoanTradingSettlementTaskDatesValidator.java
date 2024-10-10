package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanTradingSettlementTaskDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradingSettlementTaskDatesValidator implements Validator<LoanTradingSettlementTaskDates> {

	private List<ComparisonResult> getComparisonResults(LoanTradingSettlementTaskDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("raisedDate", (Date) o.getRaisedDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("expectedDate", (Date) o.getExpectedDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearedDate", (Date) o.getClearedDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LoanTradingSettlementTaskDates> validate(RosettaPath path, LoanTradingSettlementTaskDates o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradingSettlementTaskDates", ValidationType.CARDINALITY, "LoanTradingSettlementTaskDates", path, "", error);
		}
		return success("LoanTradingSettlementTaskDates", ValidationType.CARDINALITY, "LoanTradingSettlementTaskDates", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingSettlementTaskDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingSettlementTaskDates", ValidationType.CARDINALITY, "LoanTradingSettlementTaskDates", path, "", res.getError());
				}
				return success("LoanTradingSettlementTaskDates", ValidationType.CARDINALITY, "LoanTradingSettlementTaskDates", path, "");
			})
			.collect(toList());
	}

}
