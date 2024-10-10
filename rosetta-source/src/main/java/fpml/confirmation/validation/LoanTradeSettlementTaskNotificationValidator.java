package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.LoanTradeSettlementTask;
import fpml.confirmation.LoanTradeSettlementTaskNotification;
import fpml.confirmation.LoanTradeSummary;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradeSettlementTaskNotificationValidator implements Validator<LoanTradeSettlementTaskNotification> {

	private List<ComparisonResult> getComparisonResults(LoanTradeSettlementTaskNotification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (RequestMessageHeader) o.getHeader() != null ? 1 : 0, 1, 1), 
				checkCardinality("validationModel", (ValidationModel) o.getValidationModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("isCorrection", (Boolean) o.getIsCorrection() != null ? 1 : 0, 1, 1), 
				checkCardinality("correlationAndSequenceModel", (CorrelationAndSequenceModel) o.getCorrelationAndSequenceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOfModel", (OnBehalfOfModel) o.getOnBehalfOfModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("noticeDate", (Date) o.getNoticeDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("role", (LoanTradingPartyRole) o.getRole() != null ? 1 : 0, 1, 1), 
				checkCardinality("task", (List<? extends LoanTradeSettlementTask>) o.getTask() == null ? 0 : ((List<? extends LoanTradeSettlementTask>) o.getTask()).size(), 1, 0), 
				checkCardinality("tradeSummary", (List<? extends LoanTradeSummary>) o.getTradeSummary() == null ? 0 : ((List<? extends LoanTradeSummary>) o.getTradeSummary()).size(), 1, 0), 
				checkCardinality("facilityDetailsModel", (List<? extends FacilityDetailsModel>) o.getFacilityDetailsModel() == null ? 0 : ((List<? extends FacilityDetailsModel>) o.getFacilityDetailsModel()).size(), 1, 0), 
				checkCardinality("party", (List<? extends Party>) o.getParty() == null ? 0 : ((List<? extends Party>) o.getParty()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<LoanTradeSettlementTaskNotification> validate(RosettaPath path, LoanTradeSettlementTaskNotification o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradeSettlementTaskNotification", ValidationType.CARDINALITY, "LoanTradeSettlementTaskNotification", path, "", error);
		}
		return success("LoanTradeSettlementTaskNotification", ValidationType.CARDINALITY, "LoanTradeSettlementTaskNotification", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradeSettlementTaskNotification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradeSettlementTaskNotification", ValidationType.CARDINALITY, "LoanTradeSettlementTaskNotification", path, "", res.getError());
				}
				return success("LoanTradeSettlementTaskNotification", ValidationType.CARDINALITY, "LoanTradeSettlementTaskNotification", path, "");
			})
			.collect(toList());
	}

}
