package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractLoanTask;
import fpml.confirmation.validation.AbstractLoanTaskTypeFormatValidator;
import fpml.confirmation.validation.AbstractLoanTaskValidator;
import fpml.confirmation.validation.exists.AbstractLoanTaskOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AbstractLoanTask.class)
public class AbstractLoanTaskMeta implements RosettaMetaData<AbstractLoanTask> {

	@Override
	public List<Validator<? super AbstractLoanTask>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanTask, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractLoanTask> validator() {
		return new AbstractLoanTaskValidator();
	}

	@Override
	public Validator<? super AbstractLoanTask> typeFormatValidator() {
		return new AbstractLoanTaskTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanTask, Set<String>> onlyExistsValidator() {
		return new AbstractLoanTaskOnlyExistsValidator();
	}
}
