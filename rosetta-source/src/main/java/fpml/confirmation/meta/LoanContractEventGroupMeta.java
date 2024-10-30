package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanContractEventGroup;
import fpml.confirmation.validation.LoanContractEventGroupTypeFormatValidator;
import fpml.confirmation.validation.LoanContractEventGroupValidator;
import fpml.confirmation.validation.exists.LoanContractEventGroupOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanContractEventGroup.class)
public class LoanContractEventGroupMeta implements RosettaMetaData<LoanContractEventGroup> {

	@Override
	public List<Validator<? super LoanContractEventGroup>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanContractEventGroup, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanContractEventGroup> validator() {
		return new LoanContractEventGroupValidator();
	}

	@Override
	public Validator<? super LoanContractEventGroup> typeFormatValidator() {
		return new LoanContractEventGroupTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanContractEventGroup, Set<String>> onlyExistsValidator() {
		return new LoanContractEventGroupOnlyExistsValidator();
	}
}
