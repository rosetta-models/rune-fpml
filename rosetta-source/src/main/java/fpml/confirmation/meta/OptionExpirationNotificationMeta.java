package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionExpirationNotification;
import fpml.confirmation.validation.OptionExpirationNotificationTypeFormatValidator;
import fpml.confirmation.validation.OptionExpirationNotificationValidator;
import fpml.confirmation.validation.exists.OptionExpirationNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OptionExpirationNotification.class)
public class OptionExpirationNotificationMeta implements RosettaMetaData<OptionExpirationNotification> {

	@Override
	public List<Validator<? super OptionExpirationNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ExecutionNotification>create(fpml.confirmation.validation.datarule.ExecutionNotificationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OptionExpirationNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionExpirationNotification> validator() {
		return new OptionExpirationNotificationValidator();
	}

	@Override
	public Validator<? super OptionExpirationNotification> typeFormatValidator() {
		return new OptionExpirationNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionExpirationNotification, Set<String>> onlyExistsValidator() {
		return new OptionExpirationNotificationOnlyExistsValidator();
	}
}
