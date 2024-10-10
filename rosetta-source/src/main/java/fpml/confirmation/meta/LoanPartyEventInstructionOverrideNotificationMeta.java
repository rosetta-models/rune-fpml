package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanPartyEventInstructionOverrideNotification;
import fpml.confirmation.validation.LoanPartyEventInstructionOverrideNotificationTypeFormatValidator;
import fpml.confirmation.validation.LoanPartyEventInstructionOverrideNotificationValidator;
import fpml.confirmation.validation.exists.LoanPartyEventInstructionOverrideNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanPartyEventInstructionOverrideNotification.class)
public class LoanPartyEventInstructionOverrideNotificationMeta implements RosettaMetaData<LoanPartyEventInstructionOverrideNotification> {

	@Override
	public List<Validator<? super LoanPartyEventInstructionOverrideNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanPartyEventInstructionOverrideNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanPartyEventInstructionOverrideNotification> validator() {
		return new LoanPartyEventInstructionOverrideNotificationValidator();
	}

	@Override
	public Validator<? super LoanPartyEventInstructionOverrideNotification> typeFormatValidator() {
		return new LoanPartyEventInstructionOverrideNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanPartyEventInstructionOverrideNotification, Set<String>> onlyExistsValidator() {
		return new LoanPartyEventInstructionOverrideNotificationOnlyExistsValidator();
	}
}
