package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Algorithm;
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
import fpml.confirmation.PricingContext;
import fpml.confirmation.RelatedBusinessUnit;
import fpml.confirmation.RelatedParty;
import fpml.confirmation.RelatedPerson;
import fpml.confirmation.ReportingRegime;
import fpml.confirmation.ReportingRole;
import fpml.confirmation.TradeCategory;
import fpml.confirmation.TradeProcessingTimestamps;
import fpml.confirmation.Trader;
import fpml.confirmation.TransactionClassificationModel;
import fpml.confirmation.Unit;
import fpml.confirmation.VerificationMethod;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PartyTradeInformationOnlyExistsValidator implements ValidatorWithArg<PartyTradeInformation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PartyTradeInformation> ValidationResult<PartyTradeInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyAndAccountReferencesModel", ExistenceChecker.isSet((PartyAndAccountReferencesModel) o.getPartyAndAccountReferencesModel()))
				.put("relatedParty", ExistenceChecker.isSet((List<? extends RelatedParty>) o.getRelatedParty()))
				.put("reportingRole", ExistenceChecker.isSet((ReportingRole) o.getReportingRole()))
				.put("unit", ExistenceChecker.isSet((List<? extends Unit>) o.getUnit()))
				.put("relatedBusinessUnit", ExistenceChecker.isSet((List<? extends RelatedBusinessUnit>) o.getRelatedBusinessUnit()))
				.put("relatedPerson", ExistenceChecker.isSet((List<? extends RelatedPerson>) o.getRelatedPerson()))
				.put("algorithm", ExistenceChecker.isSet((List<? extends Algorithm>) o.getAlgorithm()))
				.put("isAccountingHedge", ExistenceChecker.isSet((Boolean) o.getIsAccountingHedge()))
				.put("category", ExistenceChecker.isSet((List<? extends TradeCategory>) o.getCategory()))
				.put("trader", ExistenceChecker.isSet((List<? extends Trader>) o.getTrader()))
				.put("executionDateTime", ExistenceChecker.isSet((ExecutionDateTime) o.getExecutionDateTime()))
				.put("timestamps", ExistenceChecker.isSet((TradeProcessingTimestamps) o.getTimestamps()))
				.put("intentToAllocate", ExistenceChecker.isSet((Boolean) o.getIntentToAllocate()))
				.put("allocationStatus", ExistenceChecker.isSet((AllocationReportingStatus) o.getAllocationStatus()))
				.put("intentToClear", ExistenceChecker.isSet((Boolean) o.getIntentToClear()))
				.put("clearingStatus", ExistenceChecker.isSet((ClearingStatusValue) o.getClearingStatus()))
				.put("collateralizationType", ExistenceChecker.isSet((CollateralizationType) o.getCollateralizationType()))
				.put("collateralPortfolio", ExistenceChecker.isSet((PortfolioName) o.getCollateralPortfolio()))
				.put("reportingRegime", ExistenceChecker.isSet((List<? extends ReportingRegime>) o.getReportingRegime()))
				.put("partyTradeInformationSequence", ExistenceChecker.isSet((PartyTradeInformationSequence) o.getPartyTradeInformationSequence()))
				.put("endUserExceptionDeclaration", ExistenceChecker.isSet((EndUserExceptionDeclaration) o.getEndUserExceptionDeclaration()))
				.put("nonStandardTerms", ExistenceChecker.isSet((Boolean) o.getNonStandardTerms()))
				.put("offMarketPrice", ExistenceChecker.isSet((Boolean) o.getOffMarketPrice()))
				.put("pricingContext", ExistenceChecker.isSet((List<? extends PricingContext>) o.getPricingContext()))
				.put("largeSizeTrade", ExistenceChecker.isSet((Boolean) o.getLargeSizeTrade()))
				.put("executionType", ExistenceChecker.isSet((ExecutionType) o.getExecutionType()))
				.put("executionVenueType", ExistenceChecker.isSet((ExecutionVenueType) o.getExecutionVenueType()))
				.put("verificationMethod", ExistenceChecker.isSet((VerificationMethod) o.getVerificationMethod()))
				.put("confirmationMethod", ExistenceChecker.isSet((ConfirmationMethod) o.getConfirmationMethod()))
				.put("compressedTrade", ExistenceChecker.isSet((Boolean) o.getCompressedTrade()))
				.put("transactionClassificationModel", ExistenceChecker.isSet((TransactionClassificationModel) o.getTransactionClassificationModel()))
				.put("isDisputed", ExistenceChecker.isSet((Boolean) o.getIsDisputed()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PartyTradeInformation", ValidationType.ONLY_EXISTS, "PartyTradeInformation", path, "");
		}
		return failure("PartyTradeInformation", ValidationType.ONLY_EXISTS, "PartyTradeInformation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
