package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanNotificationExceptionSequence;
import fpml.confirmation.validation.LoanNotificationExceptionSequenceTypeFormatValidator;
import fpml.confirmation.validation.LoanNotificationExceptionSequenceValidator;
import fpml.confirmation.validation.exists.LoanNotificationExceptionSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanNotificationExceptionSequence.class)
public class LoanNotificationExceptionSequenceMeta implements RosettaMetaData<LoanNotificationExceptionSequence> {

	@Override
	public List<Validator<? super LoanNotificationExceptionSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanNotificationExceptionSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanNotificationExceptionSequence> validator() {
		return new LoanNotificationExceptionSequenceValidator();
	}

	@Override
	public Validator<? super LoanNotificationExceptionSequence> typeFormatValidator() {
		return new LoanNotificationExceptionSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanNotificationExceptionSequence, Set<String>> onlyExistsValidator() {
		return new LoanNotificationExceptionSequenceOnlyExistsValidator();
	}
}
