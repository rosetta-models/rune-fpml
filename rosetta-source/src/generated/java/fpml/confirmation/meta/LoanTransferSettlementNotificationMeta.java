package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTransferSettlementNotification;
import fpml.confirmation.validation.LoanTransferSettlementNotificationTypeFormatValidator;
import fpml.confirmation.validation.LoanTransferSettlementNotificationValidator;
import fpml.confirmation.validation.exists.LoanTransferSettlementNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTransferSettlementNotification.class)
public class LoanTransferSettlementNotificationMeta implements RosettaMetaData<LoanTransferSettlementNotification> {

	@Override
	public List<Validator<? super LoanTransferSettlementNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTransferSettlementNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTransferSettlementNotification> validator() {
		return new LoanTransferSettlementNotificationValidator();
	}

	@Override
	public Validator<? super LoanTransferSettlementNotification> typeFormatValidator() {
		return new LoanTransferSettlementNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTransferSettlementNotification, Set<String>> onlyExistsValidator() {
		return new LoanTransferSettlementNotificationOnlyExistsValidator();
	}
}
