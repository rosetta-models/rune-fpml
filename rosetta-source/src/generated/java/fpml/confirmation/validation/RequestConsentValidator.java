package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ApprovalType;
import fpml.confirmation.CompressionModel;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.DeClear;
import fpml.confirmation.EventValuationModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PersonId;
import fpml.confirmation.PortfolioReferenceModel;
import fpml.confirmation.RequestConsent;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.RequestedAction;
import fpml.confirmation.TradingAndPostTradeEventsModel;
import fpml.confirmation.ValidationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RequestConsentValidator implements Validator<RequestConsent> {

	private List<ComparisonResult> getComparisonResults(RequestConsent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (RequestMessageHeader) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("validationModel", (ValidationModel) o.getValidationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("isCorrection", (Boolean) o.getIsCorrection() != null ? 1 : 0, 1, 1), 
				checkCardinality("correlationAndSequenceModel", (CorrelationAndSequenceModel) o.getCorrelationAndSequenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOfModel", (OnBehalfOfModel) o.getOnBehalfOfModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("requestedAction", (RequestedAction) o.getRequestedAction() != null ? 1 : 0, 0, 1), 
				checkCardinality("type", (ApprovalType) o.getType() != null ? 1 : 0, 0, 1), 
				checkCardinality("approver", (PersonId) o.getApprover() != null ? 1 : 0, 0, 1), 
				checkCardinality("approvingPartyReference", (PartyReference) o.getApprovingPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("portfolioReferenceModel", (PortfolioReferenceModel) o.getPortfolioReferenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("compressionModel", (CompressionModel) o.getCompressionModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradingAndPostTradeEventsModel", (TradingAndPostTradeEventsModel) o.getTradingAndPostTradeEventsModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("deClear", (DeClear) o.getDeClear() != null ? 1 : 0, 0, 1), 
				checkCardinality("eventValuationModel", (EventValuationModel) o.getEventValuationModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("partiesAndAccountsModel", (PartiesAndAccountsModel) o.getPartiesAndAccountsModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<RequestConsent> validate(RosettaPath path, RequestConsent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RequestConsent", ValidationType.CARDINALITY, "RequestConsent", path, "", error);
		}
		return success("RequestConsent", ValidationType.CARDINALITY, "RequestConsent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RequestConsent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RequestConsent", ValidationType.CARDINALITY, "RequestConsent", path, "", res.getError());
				}
				return success("RequestConsent", ValidationType.CARDINALITY, "RequestConsent", path, "");
			})
			.collect(toList());
	}

}
