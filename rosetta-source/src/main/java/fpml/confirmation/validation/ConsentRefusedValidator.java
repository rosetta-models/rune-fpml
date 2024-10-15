package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ApprovalType;
import fpml.confirmation.ConsentRefused;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.EventsOrInfoModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PersonId;
import fpml.confirmation.PortfolioReferenceBaseModel;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.ValidationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ConsentRefusedValidator implements Validator<ConsentRefused> {

	private List<ComparisonResult> getComparisonResults(ConsentRefused o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (ResponseMessageHeader) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("validationModel", (ValidationModel) o.getValidationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("correlationAndOptionalSequenceModel", (CorrelationAndOptionalSequenceModel) o.getCorrelationAndOptionalSequenceModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("onBehalfOfModel", (OnBehalfOfModel) o.getOnBehalfOfModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("_type", (ApprovalType) o.get_type() != null ? 1 : 0, 0, 1), 
				checkCardinality("approver", (PersonId) o.getApprover() != null ? 1 : 0, 0, 1), 
				checkCardinality("approvingPartyReference", (PartyReference) o.getApprovingPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("portfolioReferenceBaseModel", (PortfolioReferenceBaseModel) o.getPortfolioReferenceBaseModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("eventsOrInfoModel", (EventsOrInfoModel) o.getEventsOrInfoModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("partiesAndAccountsModel", (PartiesAndAccountsModel) o.getPartiesAndAccountsModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ConsentRefused> validate(RosettaPath path, ConsentRefused o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ConsentRefused", ValidationType.CARDINALITY, "ConsentRefused", path, "", error);
		}
		return success("ConsentRefused", ValidationType.CARDINALITY, "ConsentRefused", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConsentRefused o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ConsentRefused", ValidationType.CARDINALITY, "ConsentRefused", path, "", res.getError());
				}
				return success("ConsentRefused", ValidationType.CARDINALITY, "ConsentRefused", path, "");
			})
			.collect(toList());
	}

}
