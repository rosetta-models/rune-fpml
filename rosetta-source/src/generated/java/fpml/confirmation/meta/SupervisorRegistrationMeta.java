package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SupervisorRegistration;
import fpml.confirmation.validation.SupervisorRegistrationTypeFormatValidator;
import fpml.confirmation.validation.SupervisorRegistrationValidator;
import fpml.confirmation.validation.exists.SupervisorRegistrationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SupervisorRegistration.class)
public class SupervisorRegistrationMeta implements RosettaMetaData<SupervisorRegistration> {

	@Override
	public List<Validator<? super SupervisorRegistration>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SupervisorRegistration, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SupervisorRegistration> validator() {
		return new SupervisorRegistrationValidator();
	}

	@Override
	public Validator<? super SupervisorRegistration> typeFormatValidator() {
		return new SupervisorRegistrationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SupervisorRegistration, Set<String>> onlyExistsValidator() {
		return new SupervisorRegistrationOnlyExistsValidator();
	}
}
