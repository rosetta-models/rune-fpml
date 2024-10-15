package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AbstractLoanPartyProfileNotification;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AbstractLoanPartyProfileNotificationValidator implements Validator<AbstractLoanPartyProfileNotification> {

	private List<ComparisonResult> getComparisonResults(AbstractLoanPartyProfileNotification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (RequestMessageHeader) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("validationModel", (ValidationModel) o.getValidationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("isCorrection", (Boolean) o.getIsCorrection() != null ? 1 : 0, 1, 1), 
				checkCardinality("correlationAndSequenceModel", (CorrelationAndSequenceModel) o.getCorrelationAndSequenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOfModel", (OnBehalfOfModel) o.getOnBehalfOfModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("comments", (String) o.getComments() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<AbstractLoanPartyProfileNotification> validate(RosettaPath path, AbstractLoanPartyProfileNotification o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AbstractLoanPartyProfileNotification", ValidationType.CARDINALITY, "AbstractLoanPartyProfileNotification", path, "", error);
		}
		return success("AbstractLoanPartyProfileNotification", ValidationType.CARDINALITY, "AbstractLoanPartyProfileNotification", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractLoanPartyProfileNotification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractLoanPartyProfileNotification", ValidationType.CARDINALITY, "AbstractLoanPartyProfileNotification", path, "", res.getError());
				}
				return success("AbstractLoanPartyProfileNotification", ValidationType.CARDINALITY, "AbstractLoanPartyProfileNotification", path, "");
			})
			.collect(toList());
	}

}
