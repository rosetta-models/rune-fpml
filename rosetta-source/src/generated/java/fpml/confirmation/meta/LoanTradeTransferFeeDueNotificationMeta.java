package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradeTransferFeeDueNotification;
import fpml.confirmation.validation.LoanTradeTransferFeeDueNotificationTypeFormatValidator;
import fpml.confirmation.validation.LoanTradeTransferFeeDueNotificationValidator;
import fpml.confirmation.validation.exists.LoanTradeTransferFeeDueNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTradeTransferFeeDueNotification.class)
public class LoanTradeTransferFeeDueNotificationMeta implements RosettaMetaData<LoanTradeTransferFeeDueNotification> {

	@Override
	public List<Validator<? super LoanTradeTransferFeeDueNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradeTransferFeeDueNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradeTransferFeeDueNotification> validator() {
		return new LoanTradeTransferFeeDueNotificationValidator();
	}

	@Override
	public Validator<? super LoanTradeTransferFeeDueNotification> typeFormatValidator() {
		return new LoanTradeTransferFeeDueNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeTransferFeeDueNotification, Set<String>> onlyExistsValidator() {
		return new LoanTradeTransferFeeDueNotificationOnlyExistsValidator();
	}
}
