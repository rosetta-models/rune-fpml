package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradeTransferFeeOwedNotification;
import fpml.confirmation.validation.LoanTradeTransferFeeOwedNotificationTypeFormatValidator;
import fpml.confirmation.validation.LoanTradeTransferFeeOwedNotificationValidator;
import fpml.confirmation.validation.exists.LoanTradeTransferFeeOwedNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTradeTransferFeeOwedNotification.class)
public class LoanTradeTransferFeeOwedNotificationMeta implements RosettaMetaData<LoanTradeTransferFeeOwedNotification> {

	@Override
	public List<Validator<? super LoanTradeTransferFeeOwedNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradeTransferFeeOwedNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradeTransferFeeOwedNotification> validator() {
		return new LoanTradeTransferFeeOwedNotificationValidator();
	}

	@Override
	public Validator<? super LoanTradeTransferFeeOwedNotification> typeFormatValidator() {
		return new LoanTradeTransferFeeOwedNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeTransferFeeOwedNotification, Set<String>> onlyExistsValidator() {
		return new LoanTradeTransferFeeOwedNotificationOnlyExistsValidator();
	}
}
