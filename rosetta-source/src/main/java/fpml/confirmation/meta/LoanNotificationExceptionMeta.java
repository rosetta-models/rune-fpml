package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanNotificationException;
import fpml.confirmation.validation.LoanNotificationExceptionTypeFormatValidator;
import fpml.confirmation.validation.LoanNotificationExceptionValidator;
import fpml.confirmation.validation.exists.LoanNotificationExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanNotificationException.class)
public class LoanNotificationExceptionMeta implements RosettaMetaData<LoanNotificationException> {

	@Override
	public List<Validator<? super LoanNotificationException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanNotificationException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanNotificationException> validator() {
		return new LoanNotificationExceptionValidator();
	}

	@Override
	public Validator<? super LoanNotificationException> typeFormatValidator() {
		return new LoanNotificationExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanNotificationException, Set<String>> onlyExistsValidator() {
		return new LoanNotificationExceptionOnlyExistsValidator();
	}
}
