package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractLoanAllocationPaymentNotification;
import fpml.confirmation.validation.AbstractLoanAllocationPaymentNotificationTypeFormatValidator;
import fpml.confirmation.validation.AbstractLoanAllocationPaymentNotificationValidator;
import fpml.confirmation.validation.exists.AbstractLoanAllocationPaymentNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AbstractLoanAllocationPaymentNotification.class)
public class AbstractLoanAllocationPaymentNotificationMeta implements RosettaMetaData<AbstractLoanAllocationPaymentNotification> {

	@Override
	public List<Validator<? super AbstractLoanAllocationPaymentNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanAllocationPaymentNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractLoanAllocationPaymentNotification> validator() {
		return new AbstractLoanAllocationPaymentNotificationValidator();
	}

	@Override
	public Validator<? super AbstractLoanAllocationPaymentNotification> typeFormatValidator() {
		return new AbstractLoanAllocationPaymentNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanAllocationPaymentNotification, Set<String>> onlyExistsValidator() {
		return new AbstractLoanAllocationPaymentNotificationOnlyExistsValidator();
	}
}
