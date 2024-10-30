package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Exception;
import fpml.confirmation.validation.ExceptionTypeFormatValidator;
import fpml.confirmation.validation.ExceptionValidator;
import fpml.confirmation.validation.exists.ExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Exception.class)
public class ExceptionMeta implements RosettaMetaData<Exception> {

	@Override
	public List<Validator<? super Exception>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Exception, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Exception> validator() {
		return new ExceptionValidator();
	}

	@Override
	public Validator<? super Exception> typeFormatValidator() {
		return new ExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Exception, Set<String>> onlyExistsValidator() {
		return new ExceptionOnlyExistsValidator();
	}
}
