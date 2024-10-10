package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradeNotification;
import fpml.confirmation.validation.LoanTradeNotificationTypeFormatValidator;
import fpml.confirmation.validation.LoanTradeNotificationValidator;
import fpml.confirmation.validation.exists.LoanTradeNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTradeNotification.class)
public class LoanTradeNotificationMeta implements RosettaMetaData<LoanTradeNotification> {

	@Override
	public List<Validator<? super LoanTradeNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradeNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradeNotification> validator() {
		return new LoanTradeNotificationValidator();
	}

	@Override
	public Validator<? super LoanTradeNotification> typeFormatValidator() {
		return new LoanTradeNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeNotification, Set<String>> onlyExistsValidator() {
		return new LoanTradeNotificationOnlyExistsValidator();
	}
}
