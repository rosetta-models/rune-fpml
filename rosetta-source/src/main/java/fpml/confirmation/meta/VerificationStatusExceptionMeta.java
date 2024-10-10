package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.VerificationStatusException;
import fpml.confirmation.validation.VerificationStatusExceptionTypeFormatValidator;
import fpml.confirmation.validation.VerificationStatusExceptionValidator;
import fpml.confirmation.validation.exists.VerificationStatusExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=VerificationStatusException.class)
public class VerificationStatusExceptionMeta implements RosettaMetaData<VerificationStatusException> {

	@Override
	public List<Validator<? super VerificationStatusException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VerificationStatusException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super VerificationStatusException> validator() {
		return new VerificationStatusExceptionValidator();
	}

	@Override
	public Validator<? super VerificationStatusException> typeFormatValidator() {
		return new VerificationStatusExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VerificationStatusException, Set<String>> onlyExistsValidator() {
		return new VerificationStatusExceptionOnlyExistsValidator();
	}
}
