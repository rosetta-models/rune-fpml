package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanAllocationSettlementDateAvailabilityNotification;
import fpml.confirmation.validation.LoanAllocationSettlementDateAvailabilityNotificationTypeFormatValidator;
import fpml.confirmation.validation.LoanAllocationSettlementDateAvailabilityNotificationValidator;
import fpml.confirmation.validation.exists.LoanAllocationSettlementDateAvailabilityNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanAllocationSettlementDateAvailabilityNotification.class)
public class LoanAllocationSettlementDateAvailabilityNotificationMeta implements RosettaMetaData<LoanAllocationSettlementDateAvailabilityNotification> {

	@Override
	public List<Validator<? super LoanAllocationSettlementDateAvailabilityNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationSettlementDateAvailabilityNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanAllocationSettlementDateAvailabilityNotification> validator() {
		return new LoanAllocationSettlementDateAvailabilityNotificationValidator();
	}

	@Override
	public Validator<? super LoanAllocationSettlementDateAvailabilityNotification> typeFormatValidator() {
		return new LoanAllocationSettlementDateAvailabilityNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationSettlementDateAvailabilityNotification, Set<String>> onlyExistsValidator() {
		return new LoanAllocationSettlementDateAvailabilityNotificationOnlyExistsValidator();
	}
}
