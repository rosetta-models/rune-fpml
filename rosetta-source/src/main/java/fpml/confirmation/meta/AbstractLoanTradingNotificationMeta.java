package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractLoanTradingNotification;
import fpml.confirmation.validation.AbstractLoanTradingNotificationTypeFormatValidator;
import fpml.confirmation.validation.AbstractLoanTradingNotificationValidator;
import fpml.confirmation.validation.exists.AbstractLoanTradingNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AbstractLoanTradingNotification.class)
public class AbstractLoanTradingNotificationMeta implements RosettaMetaData<AbstractLoanTradingNotification> {

	@Override
	public List<Validator<? super AbstractLoanTradingNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanTradingNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractLoanTradingNotification> validator() {
		return new AbstractLoanTradingNotificationValidator();
	}

	@Override
	public Validator<? super AbstractLoanTradingNotification> typeFormatValidator() {
		return new AbstractLoanTradingNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanTradingNotification, Set<String>> onlyExistsValidator() {
		return new AbstractLoanTradingNotificationOnlyExistsValidator();
	}
}
