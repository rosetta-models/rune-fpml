package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.ExceptionMessageHeader;
import fpml.confirmation.ExceptionModel;
import fpml.confirmation.LoanNotificationException;
import fpml.confirmation.LoanNotificationExceptionSequence;
import fpml.confirmation.ValidationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanNotificationExceptionValidator implements Validator<LoanNotificationException> {

	private List<ComparisonResult> getComparisonResults(LoanNotificationException o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (ExceptionMessageHeader) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("validationModel", (ValidationModel) o.getValidationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("correlationAndOptionalSequenceModel", (CorrelationAndOptionalSequenceModel) o.getCorrelationAndOptionalSequenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("exceptionModel", (ExceptionModel) o.getExceptionModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("loanNotificationExceptionSequence", (LoanNotificationExceptionSequence) o.getLoanNotificationExceptionSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<LoanNotificationException> validate(RosettaPath path, LoanNotificationException o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanNotificationException", ValidationType.CARDINALITY, "LoanNotificationException", path, "", error);
		}
		return success("LoanNotificationException", ValidationType.CARDINALITY, "LoanNotificationException", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanNotificationException o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanNotificationException", ValidationType.CARDINALITY, "LoanNotificationException", path, "", res.getError());
				}
				return success("LoanNotificationException", ValidationType.CARDINALITY, "LoanNotificationException", path, "");
			})
			.collect(toList());
	}

}
