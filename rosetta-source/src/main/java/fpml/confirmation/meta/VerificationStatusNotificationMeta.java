package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.VerificationStatusNotification;
import fpml.confirmation.validation.VerificationStatusNotificationTypeFormatValidator;
import fpml.confirmation.validation.VerificationStatusNotificationValidator;
import fpml.confirmation.validation.exists.VerificationStatusNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=VerificationStatusNotification.class)
public class VerificationStatusNotificationMeta implements RosettaMetaData<VerificationStatusNotification> {

	@Override
	public List<Validator<? super VerificationStatusNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VerificationStatusNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super VerificationStatusNotification> validator() {
		return new VerificationStatusNotificationValidator();
	}

	@Override
	public Validator<? super VerificationStatusNotification> typeFormatValidator() {
		return new VerificationStatusNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VerificationStatusNotification, Set<String>> onlyExistsValidator() {
		return new VerificationStatusNotificationOnlyExistsValidator();
	}
}
