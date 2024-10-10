package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ActionType;
import fpml.confirmation.CurrencyPairClassification;
import fpml.confirmation.EntityClassification;
import fpml.confirmation.NotionalReportingType;
import fpml.confirmation.PartyEntityClassification;
import fpml.confirmation.PartyRelationshipType;
import fpml.confirmation.RelatedParty;
import fpml.confirmation.ReportingBoolean;
import fpml.confirmation.ReportingPurpose;
import fpml.confirmation.ReportingRegime;
import fpml.confirmation.ReportingRegimeSequence0;
import fpml.confirmation.ReportingRegimeSequence1;
import fpml.confirmation.ReportingRole;
import fpml.confirmation.SupervisorRegistration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReportingRegimeOnlyExistsValidator implements ValidatorWithArg<ReportingRegime, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReportingRegime> ValidationResult<ReportingRegime> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("reportingRegimeSequence0", ExistenceChecker.isSet((ReportingRegimeSequence0) o.getReportingRegimeSequence0()))
				.put("supervisorRegistration", ExistenceChecker.isSet((List<? extends SupervisorRegistration>) o.getSupervisorRegistration()))
				.put("reportingRole", ExistenceChecker.isSet((ReportingRole) o.getReportingRole()))
				.put("reportingPurpose", ExistenceChecker.isSet((List<? extends ReportingPurpose>) o.getReportingPurpose()))
				.put("mandatorilyClearable", ExistenceChecker.isSet((ReportingBoolean) o.getMandatorilyClearable()))
				.put("reportingRegimeSequence1", ExistenceChecker.isSet((ReportingRegimeSequence1) o.getReportingRegimeSequence1()))
				.put("exceedsClearingThreshold", ExistenceChecker.isSet((Boolean) o.getExceedsClearingThreshold()))
				.put("relatedParty", ExistenceChecker.isSet((List<? extends RelatedParty>) o.getRelatedParty()))
				.put("entityClassification", ExistenceChecker.isSet((EntityClassification) o.getEntityClassification()))
				.put("partyEntityClassification", ExistenceChecker.isSet((List<? extends PartyEntityClassification>) o.getPartyEntityClassification()))
				.put("tradePartyRelationshipType", ExistenceChecker.isSet((PartyRelationshipType) o.getTradePartyRelationshipType()))
				.put("actionType", ExistenceChecker.isSet((ActionType) o.getActionType()))
				.put("preEnactmentTrade", ExistenceChecker.isSet((Boolean) o.getPreEnactmentTrade()))
				.put("notionalType", ExistenceChecker.isSet((NotionalReportingType) o.getNotionalType()))
				.put("currencyPairClassification", ExistenceChecker.isSet((CurrencyPairClassification) o.getCurrencyPairClassification()))
				.put("transmissionOfOrder", ExistenceChecker.isSet((Boolean) o.getTransmissionOfOrder()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReportingRegime", ValidationType.ONLY_EXISTS, "ReportingRegime", path, "");
		}
		return failure("ReportingRegime", ValidationType.ONLY_EXISTS, "ReportingRegime", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
