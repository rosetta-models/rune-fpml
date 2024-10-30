package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TaskIdentifier;
import fpml.confirmation.validation.TaskIdentifierTypeFormatValidator;
import fpml.confirmation.validation.TaskIdentifierValidator;
import fpml.confirmation.validation.exists.TaskIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TaskIdentifier.class)
public class TaskIdentifierMeta implements RosettaMetaData<TaskIdentifier> {

	@Override
	public List<Validator<? super TaskIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TaskIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TaskIdentifier> validator() {
		return new TaskIdentifierValidator();
	}

	@Override
	public Validator<? super TaskIdentifier> typeFormatValidator() {
		return new TaskIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TaskIdentifier, Set<String>> onlyExistsValidator() {
		return new TaskIdentifierOnlyExistsValidator();
	}
}
