package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExecutionRetracted;
import fpml.confirmation.validation.ExecutionRetractedTypeFormatValidator;
import fpml.confirmation.validation.ExecutionRetractedValidator;
import fpml.confirmation.validation.exists.ExecutionRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ExecutionRetracted.class)
public class ExecutionRetractedMeta implements RosettaMetaData<ExecutionRetracted> {

	@Override
	public List<Validator<? super ExecutionRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ExecutionRetracted>create(fpml.confirmation.validation.datarule.ExecutionRetractedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ExecutionRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExecutionRetracted> validator() {
		return new ExecutionRetractedValidator();
	}

	@Override
	public Validator<? super ExecutionRetracted> typeFormatValidator() {
		return new ExecutionRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionRetracted, Set<String>> onlyExistsValidator() {
		return new ExecutionRetractedOnlyExistsValidator();
	}
}
