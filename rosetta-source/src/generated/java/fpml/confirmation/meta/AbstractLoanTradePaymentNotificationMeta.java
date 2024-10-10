package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractLoanTradePaymentNotification;
import fpml.confirmation.validation.AbstractLoanTradePaymentNotificationTypeFormatValidator;
import fpml.confirmation.validation.AbstractLoanTradePaymentNotificationValidator;
import fpml.confirmation.validation.exists.AbstractLoanTradePaymentNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AbstractLoanTradePaymentNotification.class)
public class AbstractLoanTradePaymentNotificationMeta implements RosettaMetaData<AbstractLoanTradePaymentNotification> {

	@Override
	public List<Validator<? super AbstractLoanTradePaymentNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanTradePaymentNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractLoanTradePaymentNotification> validator() {
		return new AbstractLoanTradePaymentNotificationValidator();
	}

	@Override
	public Validator<? super AbstractLoanTradePaymentNotification> typeFormatValidator() {
		return new AbstractLoanTradePaymentNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanTradePaymentNotification, Set<String>> onlyExistsValidator() {
		return new AbstractLoanTradePaymentNotificationOnlyExistsValidator();
	}
}
