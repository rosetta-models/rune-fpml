package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExecutionException;
import fpml.confirmation.validation.ExecutionExceptionTypeFormatValidator;
import fpml.confirmation.validation.ExecutionExceptionValidator;
import fpml.confirmation.validation.exists.ExecutionExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ExecutionException.class)
public class ExecutionExceptionMeta implements RosettaMetaData<ExecutionException> {

	@Override
	public List<Validator<? super ExecutionException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExecutionException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExecutionException> validator() {
		return new ExecutionExceptionValidator();
	}

	@Override
	public Validator<? super ExecutionException> typeFormatValidator() {
		return new ExecutionExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionException, Set<String>> onlyExistsValidator() {
		return new ExecutionExceptionOnlyExistsValidator();
	}
}
