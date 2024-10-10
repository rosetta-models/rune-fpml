package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanTradeReference;
import fpml.confirmation.LoanTradeSettlementTask;
import fpml.confirmation.LoanTradeSettlementTaskType;
import fpml.confirmation.LoanTradingSettlementTaskDates;
import fpml.confirmation.LoanTradingSettlementTaskStatusEnum;
import fpml.confirmation.PartyReference;
import fpml.confirmation.TaskIdentifier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradeSettlementTaskValidator implements Validator<LoanTradeSettlementTask> {

	private List<ComparisonResult> getComparisonResults(LoanTradeSettlementTask o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("taskIdentifier", (TaskIdentifier) o.getTaskIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("parentTaskIdentifier", (TaskIdentifier) o.getParentTaskIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("correctedTaskIdentifier", (TaskIdentifier) o.getCorrectedTaskIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("responsibleParty", (PartyReference) o.getResponsibleParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("dates", (LoanTradingSettlementTaskDates) o.getDates() != null ? 1 : 0, 1, 1), 
				checkCardinality("status", (LoanTradingSettlementTaskStatusEnum) o.getStatus() != null ? 1 : 0, 1, 1), 
				checkCardinality("comment", (String) o.getComment() != null ? 1 : 0, 0, 1), 
				checkCardinality("loanTradeReference", (LoanTradeReference) o.getLoanTradeReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("type", (LoanTradeSettlementTaskType) o.getType_() != null ? 1 : 0, 1, 1)
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
			return failure("LoanTradeSettlementTask", ValidationType.CARDINALITY, "LoanTradeSettlementTask", path, "", error);
		}
		return success("LoanTradeSettlementTask", ValidationType.CARDINALITY, "LoanTradeSettlementTask", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradeSettlementTask o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradeSettlementTask", ValidationType.CARDINALITY, "LoanTradeSettlementTask", path, "", res.getError());
				}
				return success("LoanTradeSettlementTask", ValidationType.CARDINALITY, "LoanTradeSettlementTask", path, "");
			})
			.collect(toList());
	}

}
