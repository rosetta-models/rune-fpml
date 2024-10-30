package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RolloverNotification;
import fpml.confirmation.validation.RolloverNotificationTypeFormatValidator;
import fpml.confirmation.validation.RolloverNotificationValidator;
import fpml.confirmation.validation.exists.RolloverNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RolloverNotification.class)
public class RolloverNotificationMeta implements RosettaMetaData<RolloverNotification> {

	@Override
	public List<Validator<? super RolloverNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RolloverNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RolloverNotification> validator() {
		return new RolloverNotificationValidator();
	}

	@Override
	public Validator<? super RolloverNotification> typeFormatValidator() {
		return new RolloverNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RolloverNotification, Set<String>> onlyExistsValidator() {
		return new RolloverNotificationOnlyExistsValidator();
	}
}
