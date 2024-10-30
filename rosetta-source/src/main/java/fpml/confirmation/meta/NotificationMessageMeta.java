package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NotificationMessage;
import fpml.confirmation.validation.NotificationMessageTypeFormatValidator;
import fpml.confirmation.validation.NotificationMessageValidator;
import fpml.confirmation.validation.exists.NotificationMessageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NotificationMessage.class)
public class NotificationMessageMeta implements RosettaMetaData<NotificationMessage> {

	@Override
	public List<Validator<? super NotificationMessage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotificationMessage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NotificationMessage> validator() {
		return new NotificationMessageValidator();
	}

	@Override
	public Validator<? super NotificationMessage> typeFormatValidator() {
		return new NotificationMessageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotificationMessage, Set<String>> onlyExistsValidator() {
		return new NotificationMessageOnlyExistsValidator();
	}
}
