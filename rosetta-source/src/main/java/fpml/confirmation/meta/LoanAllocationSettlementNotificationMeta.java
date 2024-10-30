package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanAllocationSettlementNotification;
import fpml.confirmation.validation.LoanAllocationSettlementNotificationTypeFormatValidator;
import fpml.confirmation.validation.LoanAllocationSettlementNotificationValidator;
import fpml.confirmation.validation.exists.LoanAllocationSettlementNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanAllocationSettlementNotification.class)
public class LoanAllocationSettlementNotificationMeta implements RosettaMetaData<LoanAllocationSettlementNotification> {

	@Override
	public List<Validator<? super LoanAllocationSettlementNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationSettlementNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanAllocationSettlementNotification> validator() {
		return new LoanAllocationSettlementNotificationValidator();
	}

	@Override
	public Validator<? super LoanAllocationSettlementNotification> typeFormatValidator() {
		return new LoanAllocationSettlementNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationSettlementNotification, Set<String>> onlyExistsValidator() {
		return new LoanAllocationSettlementNotificationOnlyExistsValidator();
	}
}
