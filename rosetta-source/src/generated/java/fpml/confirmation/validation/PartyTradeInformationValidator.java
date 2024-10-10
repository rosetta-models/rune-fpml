package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AllocationReportingStatus;
import fpml.confirmation.ClearingStatusValue;
import fpml.confirmation.CollateralizationType;
import fpml.confirmation.ConfirmationMethod;
import fpml.confirmation.EndUserExceptionDeclaration;
import fpml.confirmation.ExecutionDateTime;
import fpml.confirmation.ExecutionType;
import fpml.confirmation.ExecutionVenueType;
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.PartyTradeInformation;
import fpml.confirmation.PartyTradeInformationSequence;
import fpml.confirmation.PortfolioName;
import fpml.confirmation.ReportingRole;
import fpml.confirmation.TradeProcessingTimestamps;
import fpml.confirmation.TransactionClassificationModel;
import fpml.confirmation.VerificationMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartyTradeInformationValidator implements Validator<PartyTradeInformation> {

	private List<ComparisonResult> getComparisonResults(PartyTradeInformation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyAndAccountReferencesModel", (PartyAndAccountReferencesModel) o.getPartyAndAccountReferencesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("reportingRole", (ReportingRole) o.getReportingRole() != null ? 1 : 0, 0, 1), 
				checkCardinality("isAccountingHedge", (Boolean) o.getIsAccountingHedge() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionDateTime", (ExecutionDateTime) o.getExecutionDateTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("timestamps", (TradeProcessingTimestamps) o.getTimestamps() != null ? 1 : 0, 0, 1), 
				checkCardinality("intentToAllocate", (Boolean) o.getIntentToAllocate() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocationStatus", (AllocationReportingStatus) o.getAllocationStatus() != null ? 1 : 0, 0, 1), 
				checkCardinality("intentToClear", (Boolean) o.getIntentToClear() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingStatus", (ClearingStatusValue) o.getClearingStatus() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralizationType", (CollateralizationType) o.getCollateralizationType() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralPortfolio", (PortfolioName) o.getCollateralPortfolio() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyTradeInformationSequence", (PartyTradeInformationSequence) o.getPartyTradeInformationSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("endUserExceptionDeclaration", (EndUserExceptionDeclaration) o.getEndUserExceptionDeclaration() != null ? 1 : 0, 0, 1), 
				checkCardinality("nonStandardTerms", (Boolean) o.getNonStandardTerms() != null ? 1 : 0, 0, 1), 
				checkCardinality("offMarketPrice", (Boolean) o.getOffMarketPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("largeSizeTrade", (Boolean) o.getLargeSizeTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionType", (ExecutionType) o.getExecutionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionVenueType", (ExecutionVenueType) o.getExecutionVenueType() != null ? 1 : 0, 0, 1), 
				checkCardinality("verificationMethod", (VerificationMethod) o.getVerificationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("confirmationMethod", (ConfirmationMethod) o.getConfirmationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("compressedTrade", (Boolean) o.getCompressedTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("transactionClassificationModel", (TransactionClassificationModel) o.getTransactionClassificationModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("isDisputed", (Boolean) o.getIsDisputed() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PartyTradeInformation> validate(RosettaPath path, PartyTradeInformation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartyTradeInformation", ValidationType.CARDINALITY, "PartyTradeInformation", path, "", error);
		}
		return success("PartyTradeInformation", ValidationType.CARDINALITY, "PartyTradeInformation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyTradeInformation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartyTradeInformation", ValidationType.CARDINALITY, "PartyTradeInformation", path, "", res.getError());
				}
				return success("PartyTradeInformation", ValidationType.CARDINALITY, "PartyTradeInformation", path, "");
			})
			.collect(toList());
	}

}
