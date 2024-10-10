package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditEventException;
import fpml.confirmation.validation.CreditEventExceptionTypeFormatValidator;
import fpml.confirmation.validation.CreditEventExceptionValidator;
import fpml.confirmation.validation.exists.CreditEventExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CreditEventException.class)
public class CreditEventExceptionMeta implements RosettaMetaData<CreditEventException> {

	@Override
	public List<Validator<? super CreditEventException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditEventException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditEventException> validator() {
		return new CreditEventExceptionValidator();
	}

	@Override
	public Validator<? super CreditEventException> typeFormatValidator() {
		return new CreditEventExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditEventException, Set<String>> onlyExistsValidator() {
		return new CreditEventExceptionOnlyExistsValidator();
	}
}
