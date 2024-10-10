package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanPartyTradingInstructionOverrideNotification;
import fpml.confirmation.validation.LoanPartyTradingInstructionOverrideNotificationTypeFormatValidator;
import fpml.confirmation.validation.LoanPartyTradingInstructionOverrideNotificationValidator;
import fpml.confirmation.validation.exists.LoanPartyTradingInstructionOverrideNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanPartyTradingInstructionOverrideNotification.class)
public class LoanPartyTradingInstructionOverrideNotificationMeta implements RosettaMetaData<LoanPartyTradingInstructionOverrideNotification> {

	@Override
	public List<Validator<? super LoanPartyTradingInstructionOverrideNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanPartyTradingInstructionOverrideNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanPartyTradingInstructionOverrideNotification> validator() {
		return new LoanPartyTradingInstructionOverrideNotificationValidator();
	}

	@Override
	public Validator<? super LoanPartyTradingInstructionOverrideNotification> typeFormatValidator() {
		return new LoanPartyTradingInstructionOverrideNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanPartyTradingInstructionOverrideNotification, Set<String>> onlyExistsValidator() {
		return new LoanPartyTradingInstructionOverrideNotificationOnlyExistsValidator();
	}
}
