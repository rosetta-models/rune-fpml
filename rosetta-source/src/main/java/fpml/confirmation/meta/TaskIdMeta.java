package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TaskId;
import fpml.confirmation.validation.TaskIdTypeFormatValidator;
import fpml.confirmation.validation.TaskIdValidator;
import fpml.confirmation.validation.exists.TaskIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TaskId.class)
public class TaskIdMeta implements RosettaMetaData<TaskId> {

	@Override
	public List<Validator<? super TaskId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TaskId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TaskId> validator() {
		return new TaskIdValidator();
	}

	@Override
	public Validator<? super TaskId> typeFormatValidator() {
		return new TaskIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TaskId, Set<String>> onlyExistsValidator() {
		return new TaskIdOnlyExistsValidator();
	}
}
