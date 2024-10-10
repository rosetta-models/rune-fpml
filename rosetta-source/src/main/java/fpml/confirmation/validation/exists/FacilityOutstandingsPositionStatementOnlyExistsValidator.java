package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.FacilityOutstandingsPosition;
import fpml.confirmation.FacilityOutstandingsPositionStatement;
import fpml.confirmation.LoanContractDetailsModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FacilityOutstandingsPositionStatementOnlyExistsValidator implements ValidatorWithArg<FacilityOutstandingsPositionStatement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FacilityOutstandingsPositionStatement> ValidationResult<FacilityOutstandingsPositionStatement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((RequestMessageHeader) o.getHeader()))
				.put("validationModel", ExistenceChecker.isSet((ValidationModel) o.getValidationModel()))
				.put("isCorrection", ExistenceChecker.isSet((Boolean) o.getIsCorrection()))
				.put("correlationAndSequenceModel", ExistenceChecker.isSet((CorrelationAndSequenceModel) o.getCorrelationAndSequenceModel()))
				.put("onBehalfOfModel", ExistenceChecker.isSet((OnBehalfOfModel) o.getOnBehalfOfModel()))
				.put("statementDate", ExistenceChecker.isSet((Date) o.getStatementDate()))
				.put("comments", ExistenceChecker.isSet((String) o.getComments()))
				.put("facilityOutstandingsPosition", ExistenceChecker.isSet((FacilityOutstandingsPosition) o.getFacilityOutstandingsPosition()))
				.put("positionPartyReference", ExistenceChecker.isSet((PartyReference) o.getPositionPartyReference()))
				.put("facilityDetailsModel", ExistenceChecker.isSet((FacilityDetailsModel) o.getFacilityDetailsModel()))
				.put("loanContractDetailsModel", ExistenceChecker.isSet((List<? extends LoanContractDetailsModel>) o.getLoanContractDetailsModel()))
				.put("party", ExistenceChecker.isSet((List<? extends Party>) o.getParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FacilityOutstandingsPositionStatement", ValidationType.ONLY_EXISTS, "FacilityOutstandingsPositionStatement", path, "");
		}
		return failure("FacilityOutstandingsPositionStatement", ValidationType.ONLY_EXISTS, "FacilityOutstandingsPositionStatement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
