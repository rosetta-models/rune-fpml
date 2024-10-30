package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ServiceProcessingStep;
import fpml.confirmation.validation.ServiceProcessingStepTypeFormatValidator;
import fpml.confirmation.validation.ServiceProcessingStepValidator;
import fpml.confirmation.validation.exists.ServiceProcessingStepOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ServiceProcessingStep.class)
public class ServiceProcessingStepMeta implements RosettaMetaData<ServiceProcessingStep> {

	@Override
	public List<Validator<? super ServiceProcessingStep>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ServiceProcessingStep, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ServiceProcessingStep> validator() {
		return new ServiceProcessingStepValidator();
	}

	@Override
	public Validator<? super ServiceProcessingStep> typeFormatValidator() {
		return new ServiceProcessingStepTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ServiceProcessingStep, Set<String>> onlyExistsValidator() {
		return new ServiceProcessingStepOnlyExistsValidator();
	}
}
