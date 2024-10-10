package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExecutionDateTime;
import fpml.confirmation.validation.ExecutionDateTimeTypeFormatValidator;
import fpml.confirmation.validation.ExecutionDateTimeValidator;
import fpml.confirmation.validation.exists.ExecutionDateTimeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ExecutionDateTime.class)
public class ExecutionDateTimeMeta implements RosettaMetaData<ExecutionDateTime> {

	@Override
	public List<Validator<? super ExecutionDateTime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExecutionDateTime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExecutionDateTime> validator() {
		return new ExecutionDateTimeValidator();
	}

	@Override
	public Validator<? super ExecutionDateTime> typeFormatValidator() {
		return new ExecutionDateTimeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionDateTime, Set<String>> onlyExistsValidator() {
		return new ExecutionDateTimeOnlyExistsValidator();
	}
}
