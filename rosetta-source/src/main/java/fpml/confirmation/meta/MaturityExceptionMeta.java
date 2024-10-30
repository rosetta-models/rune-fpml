package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MaturityException;
import fpml.confirmation.validation.MaturityExceptionTypeFormatValidator;
import fpml.confirmation.validation.MaturityExceptionValidator;
import fpml.confirmation.validation.exists.MaturityExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MaturityException.class)
public class MaturityExceptionMeta implements RosettaMetaData<MaturityException> {

	@Override
	public List<Validator<? super MaturityException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MaturityException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MaturityException> validator() {
		return new MaturityExceptionValidator();
	}

	@Override
	public Validator<? super MaturityException> typeFormatValidator() {
		return new MaturityExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MaturityException, Set<String>> onlyExistsValidator() {
		return new MaturityExceptionOnlyExistsValidator();
	}
}
