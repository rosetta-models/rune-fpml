package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanAllocationConfirmationNotification;
import fpml.confirmation.validation.LoanAllocationConfirmationNotificationTypeFormatValidator;
import fpml.confirmation.validation.LoanAllocationConfirmationNotificationValidator;
import fpml.confirmation.validation.exists.LoanAllocationConfirmationNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanAllocationConfirmationNotification.class)
public class LoanAllocationConfirmationNotificationMeta implements RosettaMetaData<LoanAllocationConfirmationNotification> {

	@Override
	public List<Validator<? super LoanAllocationConfirmationNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationConfirmationNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanAllocationConfirmationNotification> validator() {
		return new LoanAllocationConfirmationNotificationValidator();
	}

	@Override
	public Validator<? super LoanAllocationConfirmationNotification> typeFormatValidator() {
		return new LoanAllocationConfirmationNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationConfirmationNotification, Set<String>> onlyExistsValidator() {
		return new LoanAllocationConfirmationNotificationOnlyExistsValidator();
	}
}
