package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.VerificationStatus;
import fpml.confirmation.VerificationStatusNotification;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VerificationStatusNotificationValidator implements Validator<VerificationStatusNotification> {

	private List<ComparisonResult> getComparisonResults(VerificationStatusNotification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (RequestMessageHeader) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("validationModel", (ValidationModel) o.getValidationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("correlationAndSequenceModel", (CorrelationAndSequenceModel) o.getCorrelationAndSequenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOfModel", (OnBehalfOfModel) o.getOnBehalfOfModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("status", (VerificationStatus) o.getStatus() != null ? 1 : 0, 1, 1), 
				checkCardinality("partyTradeIdentifier", (PartyTradeIdentifier) o.getPartyTradeIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("partiesAndAccountsModel", (PartiesAndAccountsModel) o.getPartiesAndAccountsModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<VerificationStatusNotification> validate(RosettaPath path, VerificationStatusNotification o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VerificationStatusNotification", ValidationType.CARDINALITY, "VerificationStatusNotification", path, "", error);
		}
		return success("VerificationStatusNotification", ValidationType.CARDINALITY, "VerificationStatusNotification", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VerificationStatusNotification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VerificationStatusNotification", ValidationType.CARDINALITY, "VerificationStatusNotification", path, "", res.getError());
				}
				return success("VerificationStatusNotification", ValidationType.CARDINALITY, "VerificationStatusNotification", path, "");
			})
			.collect(toList());
	}

}
