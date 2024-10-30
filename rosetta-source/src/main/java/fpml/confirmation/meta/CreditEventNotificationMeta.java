package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditEventNotification;
import fpml.confirmation.validation.CreditEventNotificationTypeFormatValidator;
import fpml.confirmation.validation.CreditEventNotificationValidator;
import fpml.confirmation.validation.exists.CreditEventNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CreditEventNotification.class)
public class CreditEventNotificationMeta implements RosettaMetaData<CreditEventNotification> {

	@Override
	public List<Validator<? super CreditEventNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditEventNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditEventNotification> validator() {
		return new CreditEventNotificationValidator();
	}

	@Override
	public Validator<? super CreditEventNotification> typeFormatValidator() {
		return new CreditEventNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditEventNotification, Set<String>> onlyExistsValidator() {
		return new CreditEventNotificationOnlyExistsValidator();
	}
}
