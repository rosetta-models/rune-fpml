package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ContractId;
import fpml.confirmation.validation.ContractIdTypeFormatValidator;
import fpml.confirmation.validation.ContractIdValidator;
import fpml.confirmation.validation.exists.ContractIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ContractId.class)
public class ContractIdMeta implements RosettaMetaData<ContractId> {

	@Override
	public List<Validator<? super ContractId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ContractId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ContractId> validator() {
		return new ContractIdValidator();
	}

	@Override
	public Validator<? super ContractId> typeFormatValidator() {
		return new ContractIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ContractId, Set<String>> onlyExistsValidator() {
		return new ContractIdOnlyExistsValidator();
	}
}
