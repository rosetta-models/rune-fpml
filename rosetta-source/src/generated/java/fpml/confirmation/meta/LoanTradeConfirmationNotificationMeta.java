package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradeConfirmationNotification;
import fpml.confirmation.validation.LoanTradeConfirmationNotificationTypeFormatValidator;
import fpml.confirmation.validation.LoanTradeConfirmationNotificationValidator;
import fpml.confirmation.validation.exists.LoanTradeConfirmationNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTradeConfirmationNotification.class)
public class LoanTradeConfirmationNotificationMeta implements RosettaMetaData<LoanTradeConfirmationNotification> {

	@Override
	public List<Validator<? super LoanTradeConfirmationNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradeConfirmationNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradeConfirmationNotification> validator() {
		return new LoanTradeConfirmationNotificationValidator();
	}

	@Override
	public Validator<? super LoanTradeConfirmationNotification> typeFormatValidator() {
		return new LoanTradeConfirmationNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeConfirmationNotification, Set<String>> onlyExistsValidator() {
		return new LoanTradeConfirmationNotificationOnlyExistsValidator();
	}
}
