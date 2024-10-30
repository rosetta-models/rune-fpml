package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SupervisorRegistrationModel;
import fpml.confirmation.validation.SupervisorRegistrationModelTypeFormatValidator;
import fpml.confirmation.validation.SupervisorRegistrationModelValidator;
import fpml.confirmation.validation.exists.SupervisorRegistrationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SupervisorRegistrationModel.class)
public class SupervisorRegistrationModelMeta implements RosettaMetaData<SupervisorRegistrationModel> {

	@Override
	public List<Validator<? super SupervisorRegistrationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SupervisorRegistrationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SupervisorRegistrationModel> validator() {
		return new SupervisorRegistrationModelValidator();
	}

	@Override
	public Validator<? super SupervisorRegistrationModel> typeFormatValidator() {
		return new SupervisorRegistrationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SupervisorRegistrationModel, Set<String>> onlyExistsValidator() {
		return new SupervisorRegistrationModelOnlyExistsValidator();
	}
}
