package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccountSequence;
import fpml.confirmation.validation.AccountSequenceTypeFormatValidator;
import fpml.confirmation.validation.AccountSequenceValidator;
import fpml.confirmation.validation.exists.AccountSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AccountSequence.class)
public class AccountSequenceMeta implements RosettaMetaData<AccountSequence> {

	@Override
	public List<Validator<? super AccountSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccountSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccountSequence> validator() {
		return new AccountSequenceValidator();
	}

	@Override
	public Validator<? super AccountSequence> typeFormatValidator() {
		return new AccountSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccountSequence, Set<String>> onlyExistsValidator() {
		return new AccountSequenceOnlyExistsValidator();
	}
}
