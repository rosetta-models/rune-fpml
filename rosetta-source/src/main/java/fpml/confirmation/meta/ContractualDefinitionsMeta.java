package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ContractualDefinitions;
import fpml.confirmation.validation.ContractualDefinitionsTypeFormatValidator;
import fpml.confirmation.validation.ContractualDefinitionsValidator;
import fpml.confirmation.validation.exists.ContractualDefinitionsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ContractualDefinitions.class)
public class ContractualDefinitionsMeta implements RosettaMetaData<ContractualDefinitions> {

	@Override
	public List<Validator<? super ContractualDefinitions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ContractualDefinitions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ContractualDefinitions> validator() {
		return new ContractualDefinitionsValidator();
	}

	@Override
	public Validator<? super ContractualDefinitions> typeFormatValidator() {
		return new ContractualDefinitionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ContractualDefinitions, Set<String>> onlyExistsValidator() {
		return new ContractualDefinitionsOnlyExistsValidator();
	}
}
