package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ConfirmationException;
import fpml.confirmation.validation.ConfirmationExceptionTypeFormatValidator;
import fpml.confirmation.validation.ConfirmationExceptionValidator;
import fpml.confirmation.validation.exists.ConfirmationExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ConfirmationException.class)
public class ConfirmationExceptionMeta implements RosettaMetaData<ConfirmationException> {

	@Override
	public List<Validator<? super ConfirmationException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ConfirmationException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ConfirmationException> validator() {
		return new ConfirmationExceptionValidator();
	}

	@Override
	public Validator<? super ConfirmationException> typeFormatValidator() {
		return new ConfirmationExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConfirmationException, Set<String>> onlyExistsValidator() {
		return new ConfirmationExceptionOnlyExistsValidator();
	}
}
