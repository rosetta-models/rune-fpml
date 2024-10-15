package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ServiceProcessingCycle;
import fpml.confirmation.validation.ServiceProcessingCycleTypeFormatValidator;
import fpml.confirmation.validation.ServiceProcessingCycleValidator;
import fpml.confirmation.validation.exists.ServiceProcessingCycleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ServiceProcessingCycle.class)
public class ServiceProcessingCycleMeta implements RosettaMetaData<ServiceProcessingCycle> {

	@Override
	public List<Validator<? super ServiceProcessingCycle>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ServiceProcessingCycle, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ServiceProcessingCycle> validator() {
		return new ServiceProcessingCycleValidator();
	}

	@Override
	public Validator<? super ServiceProcessingCycle> typeFormatValidator() {
		return new ServiceProcessingCycleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ServiceProcessingCycle, Set<String>> onlyExistsValidator() {
		return new ServiceProcessingCycleOnlyExistsValidator();
	}
}
