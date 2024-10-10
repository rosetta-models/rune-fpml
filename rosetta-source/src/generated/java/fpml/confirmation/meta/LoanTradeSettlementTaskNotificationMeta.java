package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradeSettlementTaskNotification;
import fpml.confirmation.validation.LoanTradeSettlementTaskNotificationTypeFormatValidator;
import fpml.confirmation.validation.LoanTradeSettlementTaskNotificationValidator;
import fpml.confirmation.validation.exists.LoanTradeSettlementTaskNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTradeSettlementTaskNotification.class)
public class LoanTradeSettlementTaskNotificationMeta implements RosettaMetaData<LoanTradeSettlementTaskNotification> {

	@Override
	public List<Validator<? super LoanTradeSettlementTaskNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradeSettlementTaskNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradeSettlementTaskNotification> validator() {
		return new LoanTradeSettlementTaskNotificationValidator();
	}

	@Override
	public Validator<? super LoanTradeSettlementTaskNotification> typeFormatValidator() {
		return new LoanTradeSettlementTaskNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeSettlementTaskNotification, Set<String>> onlyExistsValidator() {
		return new LoanTradeSettlementTaskNotificationOnlyExistsValidator();
	}
}
