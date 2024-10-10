package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanAllocationSettlementDateFinalizationNotification;
import fpml.confirmation.validation.LoanAllocationSettlementDateFinalizationNotificationTypeFormatValidator;
import fpml.confirmation.validation.LoanAllocationSettlementDateFinalizationNotificationValidator;
import fpml.confirmation.validation.exists.LoanAllocationSettlementDateFinalizationNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanAllocationSettlementDateFinalizationNotification.class)
public class LoanAllocationSettlementDateFinalizationNotificationMeta implements RosettaMetaData<LoanAllocationSettlementDateFinalizationNotification> {

	@Override
	public List<Validator<? super LoanAllocationSettlementDateFinalizationNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationSettlementDateFinalizationNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanAllocationSettlementDateFinalizationNotification> validator() {
		return new LoanAllocationSettlementDateFinalizationNotificationValidator();
	}

	@Override
	public Validator<? super LoanAllocationSettlementDateFinalizationNotification> typeFormatValidator() {
		return new LoanAllocationSettlementDateFinalizationNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationSettlementDateFinalizationNotification, Set<String>> onlyExistsValidator() {
		return new LoanAllocationSettlementDateFinalizationNotificationOnlyExistsValidator();
	}
}
