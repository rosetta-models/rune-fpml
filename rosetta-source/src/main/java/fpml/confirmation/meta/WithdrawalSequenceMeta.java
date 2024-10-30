package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.WithdrawalSequence;
import fpml.confirmation.validation.WithdrawalSequenceTypeFormatValidator;
import fpml.confirmation.validation.WithdrawalSequenceValidator;
import fpml.confirmation.validation.exists.WithdrawalSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=WithdrawalSequence.class)
public class WithdrawalSequenceMeta implements RosettaMetaData<WithdrawalSequence> {

	@Override
	public List<Validator<? super WithdrawalSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WithdrawalSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super WithdrawalSequence> validator() {
		return new WithdrawalSequenceValidator();
	}

	@Override
	public Validator<? super WithdrawalSequence> typeFormatValidator() {
		return new WithdrawalSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WithdrawalSequence, Set<String>> onlyExistsValidator() {
		return new WithdrawalSequenceOnlyExistsValidator();
	}
}
