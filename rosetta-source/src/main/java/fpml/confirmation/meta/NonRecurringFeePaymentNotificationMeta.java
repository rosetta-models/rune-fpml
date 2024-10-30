package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NonRecurringFeePaymentNotification;
import fpml.confirmation.validation.NonRecurringFeePaymentNotificationTypeFormatValidator;
import fpml.confirmation.validation.NonRecurringFeePaymentNotificationValidator;
import fpml.confirmation.validation.exists.NonRecurringFeePaymentNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NonRecurringFeePaymentNotification.class)
public class NonRecurringFeePaymentNotificationMeta implements RosettaMetaData<NonRecurringFeePaymentNotification> {

	@Override
	public List<Validator<? super NonRecurringFeePaymentNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonRecurringFeePaymentNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NonRecurringFeePaymentNotification> validator() {
		return new NonRecurringFeePaymentNotificationValidator();
	}

	@Override
	public Validator<? super NonRecurringFeePaymentNotification> typeFormatValidator() {
		return new NonRecurringFeePaymentNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonRecurringFeePaymentNotification, Set<String>> onlyExistsValidator() {
		return new NonRecurringFeePaymentNotificationOnlyExistsValidator();
	}
}
