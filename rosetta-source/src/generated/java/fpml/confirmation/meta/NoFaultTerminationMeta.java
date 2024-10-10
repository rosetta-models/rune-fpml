package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NoFaultTermination;
import fpml.confirmation.validation.NoFaultTerminationTypeFormatValidator;
import fpml.confirmation.validation.NoFaultTerminationValidator;
import fpml.confirmation.validation.exists.NoFaultTerminationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NoFaultTermination.class)
public class NoFaultTerminationMeta implements RosettaMetaData<NoFaultTermination> {

	@Override
	public List<Validator<? super NoFaultTermination>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NoFaultTermination, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NoFaultTermination> validator() {
		return new NoFaultTerminationValidator();
	}

	@Override
	public Validator<? super NoFaultTermination> typeFormatValidator() {
		return new NoFaultTerminationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NoFaultTermination, Set<String>> onlyExistsValidator() {
		return new NoFaultTerminationOnlyExistsValidator();
	}
}
