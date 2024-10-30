package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExecutionAdvice;
import fpml.confirmation.validation.ExecutionAdviceTypeFormatValidator;
import fpml.confirmation.validation.ExecutionAdviceValidator;
import fpml.confirmation.validation.exists.ExecutionAdviceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ExecutionAdvice.class)
public class ExecutionAdviceMeta implements RosettaMetaData<ExecutionAdvice> {

	@Override
	public List<Validator<? super ExecutionAdvice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ExecutionAdvice>create(fpml.confirmation.validation.datarule.ExecutionAdviceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ExecutionAdvice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExecutionAdvice> validator() {
		return new ExecutionAdviceValidator();
	}

	@Override
	public Validator<? super ExecutionAdvice> typeFormatValidator() {
		return new ExecutionAdviceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionAdvice, Set<String>> onlyExistsValidator() {
		return new ExecutionAdviceOnlyExistsValidator();
	}
}
