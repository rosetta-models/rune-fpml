package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.FacilityLoanContractDetailsModel;
import fpml.confirmation.LoanAllocationPayment;
import fpml.confirmation.LoanAllocationSettlementEvent;
import fpml.confirmation.LoanAllocationSettlementNotification;
import fpml.confirmation.LoanTradeAllocationDetailsModel;
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

public class LoanAllocationSettlementNotificationValidator implements Validator<LoanAllocationSettlementNotification> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationSettlementNotification o) {
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
				checkCardinality("payment", (List<? extends LoanAllocationPayment>) o.getPayment() == null ? 0 : ((List<? extends LoanAllocationPayment>) o.getPayment()).size(), 1, 0), 
				checkCardinality("settlement", (List<? extends LoanAllocationSettlementEvent>) o.getSettlement() == null ? 0 : ((List<? extends LoanAllocationSettlementEvent>) o.getSettlement()).size(), 1, 0), 
				checkCardinality("loanTradeAllocationDetailsModel", (List<? extends LoanTradeAllocationDetailsModel>) o.getLoanTradeAllocationDetailsModel() == null ? 0 : ((List<? extends LoanTradeAllocationDetailsModel>) o.getLoanTradeAllocationDetailsModel()).size(), 1, 0), 
				checkCardinality("facilityLoanContractDetailsModel", (List<? extends FacilityLoanContractDetailsModel>) o.getFacilityLoanContractDetailsModel() == null ? 0 : ((List<? extends FacilityLoanContractDetailsModel>) o.getFacilityLoanContractDetailsModel()).size(), 1, 0), 
				checkCardinality("party", (List<? extends Party>) o.getParty() == null ? 0 : ((List<? extends Party>) o.getParty()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<LoanAllocationSettlementNotification> validate(RosettaPath path, LoanAllocationSettlementNotification o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanAllocationSettlementNotification", ValidationType.CARDINALITY, "LoanAllocationSettlementNotification", path, "", error);
		}
		return success("LoanAllocationSettlementNotification", ValidationType.CARDINALITY, "LoanAllocationSettlementNotification", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationSettlementNotification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationSettlementNotification", ValidationType.CARDINALITY, "LoanAllocationSettlementNotification", path, "", res.getError());
				}
				return success("LoanAllocationSettlementNotification", ValidationType.CARDINALITY, "LoanAllocationSettlementNotification", path, "");
			})
			.collect(toList());
	}

}
