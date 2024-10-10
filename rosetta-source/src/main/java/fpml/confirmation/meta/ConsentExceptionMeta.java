package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ConsentException;
import fpml.confirmation.validation.ConsentExceptionTypeFormatValidator;
import fpml.confirmation.validation.ConsentExceptionValidator;
import fpml.confirmation.validation.exists.ConsentExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ConsentException.class)
public class ConsentExceptionMeta implements RosettaMetaData<ConsentException> {

	@Override
	public List<Validator<? super ConsentException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ConsentException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ConsentException> validator() {
		return new ConsentExceptionValidator();
	}

	@Override
	public Validator<? super ConsentException> typeFormatValidator() {
		return new ConsentExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConsentException, Set<String>> onlyExistsValidator() {
		return new ConsentExceptionOnlyExistsValidator();
	}
}
