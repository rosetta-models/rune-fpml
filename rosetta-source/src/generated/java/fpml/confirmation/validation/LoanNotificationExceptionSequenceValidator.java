package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanIdentifiersModel;
import fpml.confirmation.LoanNotificationExceptionSequence;
import fpml.confirmation.Party;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanNotificationExceptionSequenceValidator implements Validator<LoanNotificationExceptionSequence> {

	private List<ComparisonResult> getComparisonResults(LoanNotificationExceptionSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("loanIdentifiersModel", (LoanIdentifiersModel) o.getLoanIdentifiersModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("party", (Party) o.getParty() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<LoanNotificationExceptionSequence> validate(RosettaPath path, LoanNotificationExceptionSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanNotificationExceptionSequence", ValidationType.CARDINALITY, "LoanNotificationExceptionSequence", path, "", error);
		}
		return success("LoanNotificationExceptionSequence", ValidationType.CARDINALITY, "LoanNotificationExceptionSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanNotificationExceptionSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanNotificationExceptionSequence", ValidationType.CARDINALITY, "LoanNotificationExceptionSequence", path, "", res.getError());
				}
				return success("LoanNotificationExceptionSequence", ValidationType.CARDINALITY, "LoanNotificationExceptionSequence", path, "");
			})
			.collect(toList());
	}

}
