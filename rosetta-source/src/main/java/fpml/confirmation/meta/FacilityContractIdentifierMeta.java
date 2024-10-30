package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityContractIdentifier;
import fpml.confirmation.validation.FacilityContractIdentifierTypeFormatValidator;
import fpml.confirmation.validation.FacilityContractIdentifierValidator;
import fpml.confirmation.validation.exists.FacilityContractIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FacilityContractIdentifier.class)
public class FacilityContractIdentifierMeta implements RosettaMetaData<FacilityContractIdentifier> {

	@Override
	public List<Validator<? super FacilityContractIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ContractIdentifier>create(fpml.confirmation.validation.datarule.ContractIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FacilityContractIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityContractIdentifier> validator() {
		return new FacilityContractIdentifierValidator();
	}

	@Override
	public Validator<? super FacilityContractIdentifier> typeFormatValidator() {
		return new FacilityContractIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityContractIdentifier, Set<String>> onlyExistsValidator() {
		return new FacilityContractIdentifierOnlyExistsValidator();
	}
}
