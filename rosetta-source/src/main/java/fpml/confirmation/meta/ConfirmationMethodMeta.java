package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ConfirmationMethod;
import fpml.confirmation.validation.ConfirmationMethodTypeFormatValidator;
import fpml.confirmation.validation.ConfirmationMethodValidator;
import fpml.confirmation.validation.exists.ConfirmationMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ConfirmationMethod.class)
public class ConfirmationMethodMeta implements RosettaMetaData<ConfirmationMethod> {

	@Override
	public List<Validator<? super ConfirmationMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ConfirmationMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ConfirmationMethod> validator() {
		return new ConfirmationMethodValidator();
	}

	@Override
	public Validator<? super ConfirmationMethod> typeFormatValidator() {
		return new ConfirmationMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConfirmationMethod, Set<String>> onlyExistsValidator() {
		return new ConfirmationMethodOnlyExistsValidator();
	}
}
