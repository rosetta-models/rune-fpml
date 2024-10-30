package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RequestExecution;
import fpml.confirmation.validation.RequestExecutionTypeFormatValidator;
import fpml.confirmation.validation.RequestExecutionValidator;
import fpml.confirmation.validation.exists.RequestExecutionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RequestExecution.class)
public class RequestExecutionMeta implements RosettaMetaData<RequestExecution> {

	@Override
	public List<Validator<? super RequestExecution>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.RequestExecution>create(fpml.confirmation.validation.datarule.RequestExecutionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RequestExecution, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RequestExecution> validator() {
		return new RequestExecutionValidator();
	}

	@Override
	public Validator<? super RequestExecution> typeFormatValidator() {
		return new RequestExecutionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestExecution, Set<String>> onlyExistsValidator() {
		return new RequestExecutionOnlyExistsValidator();
	}
}
