package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PrepaymentNotification;
import fpml.confirmation.validation.PrepaymentNotificationTypeFormatValidator;
import fpml.confirmation.validation.PrepaymentNotificationValidator;
import fpml.confirmation.validation.exists.PrepaymentNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PrepaymentNotification.class)
public class PrepaymentNotificationMeta implements RosettaMetaData<PrepaymentNotification> {

	@Override
	public List<Validator<? super PrepaymentNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PrepaymentNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PrepaymentNotification> validator() {
		return new PrepaymentNotificationValidator();
	}

	@Override
	public Validator<? super PrepaymentNotification> typeFormatValidator() {
		return new PrepaymentNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PrepaymentNotification, Set<String>> onlyExistsValidator() {
		return new PrepaymentNotificationOnlyExistsValidator();
	}
}
