package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BrokerConfirmation;
import fpml.confirmation.ContractualDefinitions;
import fpml.confirmation.ContractualMatrix;
import fpml.confirmation.ContractualTermsSupplement;
import fpml.confirmation.CreditSupportAgreement;
import fpml.confirmation.Documentation;
import fpml.confirmation.MasterAgreement;
import fpml.confirmation.MasterConfirmation;
import fpml.confirmation.OtherAgreement;
import fpml.confirmation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DocumentationOnlyExistsValidator implements ValidatorWithArg<Documentation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Documentation> ValidationResult<Documentation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("masterAgreement", ExistenceChecker.isSet((MasterAgreement) o.getMasterAgreement()))
				.put("masterConfirmation", ExistenceChecker.isSet((MasterConfirmation) o.getMasterConfirmation()))
				.put("brokerConfirmation", ExistenceChecker.isSet((BrokerConfirmation) o.getBrokerConfirmation()))
				.put("contractualDefinitions", ExistenceChecker.isSet((List<? extends ContractualDefinitions>) o.getContractualDefinitions()))
				.put("contractualTermsSupplement", ExistenceChecker.isSet((List<? extends ContractualTermsSupplement>) o.getContractualTermsSupplement()))
				.put("contractualMatrix", ExistenceChecker.isSet((List<? extends ContractualMatrix>) o.getContractualMatrix()))
				.put("creditSupportAgreement", ExistenceChecker.isSet((CreditSupportAgreement) o.getCreditSupportAgreement()))
				.put("otherAgreement", ExistenceChecker.isSet((List<? extends OtherAgreement>) o.getOtherAgreement()))
				.put("attachment", ExistenceChecker.isSet((List<? extends Resource>) o.getAttachment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Documentation", ValidationType.ONLY_EXISTS, "Documentation", path, "");
		}
		return failure("Documentation", ValidationType.ONLY_EXISTS, "Documentation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
