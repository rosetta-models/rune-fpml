package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbstractLoanTask;
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

public class AbstractLoanTaskValidator implements Validator<AbstractLoanTask> {

	private List<ComparisonResult> getComparisonResults(AbstractLoanTask o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("taskIdentifier", (TaskIdentifier) o.getTaskIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("parentTaskIdentifier", (TaskIdentifier) o.getParentTaskIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("correctedTaskIdentifier", (TaskIdentifier) o.getCorrectedTaskIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("responsibleParty", (PartyReference) o.getResponsibleParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("dates", (LoanTradingSettlementTaskDates) o.getDates() != null ? 1 : 0, 1, 1), 
				checkCardinality("status", (LoanTradingSettlementTaskStatusEnum) o.getStatus() != null ? 1 : 0, 1, 1), 
				checkCardinality("comment", (String) o.getComment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<AbstractLoanTask> validate(RosettaPath path, AbstractLoanTask o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AbstractLoanTask", ValidationType.CARDINALITY, "AbstractLoanTask", path, "", error);
		}
		return success("AbstractLoanTask", ValidationType.CARDINALITY, "AbstractLoanTask", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractLoanTask o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractLoanTask", ValidationType.CARDINALITY, "AbstractLoanTask", path, "", res.getError());
				}
				return success("AbstractLoanTask", ValidationType.CARDINALITY, "AbstractLoanTask", path, "");
			})
			.collect(toList());
	}

}
