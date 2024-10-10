package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ClearingException;
import fpml.confirmation.validation.ClearingExceptionTypeFormatValidator;
import fpml.confirmation.validation.ClearingExceptionValidator;
import fpml.confirmation.validation.exists.ClearingExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ClearingException.class)
public class ClearingExceptionMeta implements RosettaMetaData<ClearingException> {

	@Override
	public List<Validator<? super ClearingException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearingException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ClearingException> validator() {
		return new ClearingExceptionValidator();
	}

	@Override
	public Validator<? super ClearingException> typeFormatValidator() {
		return new ClearingExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingException, Set<String>> onlyExistsValidator() {
		return new ClearingExceptionOnlyExistsValidator();
	}
}
