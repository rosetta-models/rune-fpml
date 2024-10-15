package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanContract;
import fpml.confirmation.validation.LoanContractTypeFormatValidator;
import fpml.confirmation.validation.LoanContractValidator;
import fpml.confirmation.validation.exists.LoanContractOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanContract.class)
public class LoanContractMeta implements RosettaMetaData<LoanContract> {

	@Override
	public List<Validator<? super LoanContract>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.LoanContract>create(fpml.confirmation.validation.datarule.LoanContractChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanContract, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanContract> validator() {
		return new LoanContractValidator();
	}

	@Override
	public Validator<? super LoanContract> typeFormatValidator() {
		return new LoanContractTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanContract, Set<String>> onlyExistsValidator() {
		return new LoanContractOnlyExistsValidator();
	}
}
