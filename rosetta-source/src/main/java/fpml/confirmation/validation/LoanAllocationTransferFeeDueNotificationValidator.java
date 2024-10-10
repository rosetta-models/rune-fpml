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
import fpml.confirmation.LoanAllocationPayment;
import fpml.confirmation.LoanAllocationTransferFeeDueEvent;
import fpml.confirmation.LoanAllocationTransferFeeDueNotification;
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

public class LoanAllocationTransferFeeDueNotificationValidator implements Validator<LoanAllocationTransferFeeDueNotification> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationTransferFeeDueNotification o) {
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
				checkCardinality("feeDue", (List<? extends LoanAllocationTransferFeeDueEvent>) o.getFeeDue() == null ? 0 : ((List<? extends LoanAllocationTransferFeeDueEvent>) o.getFeeDue()).size(), 1, 0), 
				checkCardinality("loanTradeAllocationDetailsModel", (List<? extends LoanTradeAllocationDetailsModel>) o.getLoanTradeAllocationDetailsModel() == null ? 0 : ((List<? extends LoanTradeAllocationDetailsModel>) o.getLoanTradeAllocationDetailsModel()).size(), 1, 0), 
				checkCardinality("facilityDetailsModel", (List<? extends FacilityDetailsModel>) o.getFacilityDetailsModel() == null ? 0 : ((List<? extends FacilityDetailsModel>) o.getFacilityDetailsModel()).size(), 1, 0), 
				checkCardinality("party", (List<? extends Party>) o.getParty() == null ? 0 : ((List<? extends Party>) o.getParty()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<LoanAllocationTransferFeeDueNotification> validate(RosettaPath path, LoanAllocationTransferFeeDueNotification o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanAllocationTransferFeeDueNotification", ValidationType.CARDINALITY, "LoanAllocationTransferFeeDueNotification", path, "", error);
		}
		return success("LoanAllocationTransferFeeDueNotification", ValidationType.CARDINALITY, "LoanAllocationTransferFeeDueNotification", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationTransferFeeDueNotification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationTransferFeeDueNotification", ValidationType.CARDINALITY, "LoanAllocationTransferFeeDueNotification", path, "", res.getError());
				}
				return success("LoanAllocationTransferFeeDueNotification", ValidationType.CARDINALITY, "LoanAllocationTransferFeeDueNotification", path, "");
			})
			.collect(toList());
	}

}
