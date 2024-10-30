package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExecutionNotification;
import fpml.confirmation.validation.ExecutionNotificationTypeFormatValidator;
import fpml.confirmation.validation.ExecutionNotificationValidator;
import fpml.confirmation.validation.exists.ExecutionNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ExecutionNotification.class)
public class ExecutionNotificationMeta implements RosettaMetaData<ExecutionNotification> {

	@Override
	public List<Validator<? super ExecutionNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ExecutionNotification>create(fpml.confirmation.validation.datarule.ExecutionNotificationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ExecutionNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExecutionNotification> validator() {
		return new ExecutionNotificationValidator();
	}

	@Override
	public Validator<? super ExecutionNotification> typeFormatValidator() {
		return new ExecutionNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionNotification, Set<String>> onlyExistsValidator() {
		return new ExecutionNotificationOnlyExistsValidator();
	}
}
