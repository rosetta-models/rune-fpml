package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ServiceNotification;
import fpml.confirmation.validation.ServiceNotificationTypeFormatValidator;
import fpml.confirmation.validation.ServiceNotificationValidator;
import fpml.confirmation.validation.exists.ServiceNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ServiceNotification.class)
public class ServiceNotificationMeta implements RosettaMetaData<ServiceNotification> {

	@Override
	public List<Validator<? super ServiceNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ServiceNotification>create(fpml.confirmation.validation.datarule.ServiceNotificationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ServiceNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ServiceNotification> validator() {
		return new ServiceNotificationValidator();
	}

	@Override
	public Validator<? super ServiceNotification> typeFormatValidator() {
		return new ServiceNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ServiceNotification, Set<String>> onlyExistsValidator() {
		return new ServiceNotificationOnlyExistsValidator();
	}
}
