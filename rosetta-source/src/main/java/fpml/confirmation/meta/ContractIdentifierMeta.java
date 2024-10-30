package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ContractIdentifier;
import fpml.confirmation.validation.ContractIdentifierTypeFormatValidator;
import fpml.confirmation.validation.ContractIdentifierValidator;
import fpml.confirmation.validation.exists.ContractIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ContractIdentifier.class)
public class ContractIdentifierMeta implements RosettaMetaData<ContractIdentifier> {

	@Override
	public List<Validator<? super ContractIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ContractIdentifier>create(fpml.confirmation.validation.datarule.ContractIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ContractIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ContractIdentifier> validator() {
		return new ContractIdentifierValidator();
	}

	@Override
	public Validator<? super ContractIdentifier> typeFormatValidator() {
		return new ContractIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ContractIdentifier, Set<String>> onlyExistsValidator() {
		return new ContractIdentifierOnlyExistsValidator();
	}
}
