package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionalEarlyTermination;
import fpml.confirmation.validation.OptionalEarlyTerminationTypeFormatValidator;
import fpml.confirmation.validation.OptionalEarlyTerminationValidator;
import fpml.confirmation.validation.exists.OptionalEarlyTerminationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OptionalEarlyTermination.class)
public class OptionalEarlyTerminationMeta implements RosettaMetaData<OptionalEarlyTermination> {

	@Override
	public List<Validator<? super OptionalEarlyTermination>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionalEarlyTermination, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionalEarlyTermination> validator() {
		return new OptionalEarlyTerminationValidator();
	}

	@Override
	public Validator<? super OptionalEarlyTermination> typeFormatValidator() {
		return new OptionalEarlyTerminationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionalEarlyTermination, Set<String>> onlyExistsValidator() {
		return new OptionalEarlyTerminationOnlyExistsValidator();
	}
}
