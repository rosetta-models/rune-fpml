package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExecutionAdviceRetracted;
import fpml.confirmation.validation.ExecutionAdviceRetractedTypeFormatValidator;
import fpml.confirmation.validation.ExecutionAdviceRetractedValidator;
import fpml.confirmation.validation.exists.ExecutionAdviceRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ExecutionAdviceRetracted.class)
public class ExecutionAdviceRetractedMeta implements RosettaMetaData<ExecutionAdviceRetracted> {

	@Override
	public List<Validator<? super ExecutionAdviceRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ExecutionAdviceRetracted>create(fpml.confirmation.validation.datarule.ExecutionAdviceRetractedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ExecutionAdviceRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExecutionAdviceRetracted> validator() {
		return new ExecutionAdviceRetractedValidator();
	}

	@Override
	public Validator<? super ExecutionAdviceRetracted> typeFormatValidator() {
		return new ExecutionAdviceRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionAdviceRetracted, Set<String>> onlyExistsValidator() {
		return new ExecutionAdviceRetractedOnlyExistsValidator();
	}
}
