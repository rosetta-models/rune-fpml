package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanAllocationTransferFeeDueNotification;
import fpml.confirmation.validation.LoanAllocationTransferFeeDueNotificationTypeFormatValidator;
import fpml.confirmation.validation.LoanAllocationTransferFeeDueNotificationValidator;
import fpml.confirmation.validation.exists.LoanAllocationTransferFeeDueNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanAllocationTransferFeeDueNotification.class)
public class LoanAllocationTransferFeeDueNotificationMeta implements RosettaMetaData<LoanAllocationTransferFeeDueNotification> {

	@Override
	public List<Validator<? super LoanAllocationTransferFeeDueNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationTransferFeeDueNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanAllocationTransferFeeDueNotification> validator() {
		return new LoanAllocationTransferFeeDueNotificationValidator();
	}

	@Override
	public Validator<? super LoanAllocationTransferFeeDueNotification> typeFormatValidator() {
		return new LoanAllocationTransferFeeDueNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationTransferFeeDueNotification, Set<String>> onlyExistsValidator() {
		return new LoanAllocationTransferFeeDueNotificationOnlyExistsValidator();
	}
}
