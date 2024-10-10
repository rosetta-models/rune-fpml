package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanAllocationTransferFeeOwedNotification;
import fpml.confirmation.validation.LoanAllocationTransferFeeOwedNotificationTypeFormatValidator;
import fpml.confirmation.validation.LoanAllocationTransferFeeOwedNotificationValidator;
import fpml.confirmation.validation.exists.LoanAllocationTransferFeeOwedNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanAllocationTransferFeeOwedNotification.class)
public class LoanAllocationTransferFeeOwedNotificationMeta implements RosettaMetaData<LoanAllocationTransferFeeOwedNotification> {

	@Override
	public List<Validator<? super LoanAllocationTransferFeeOwedNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationTransferFeeOwedNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanAllocationTransferFeeOwedNotification> validator() {
		return new LoanAllocationTransferFeeOwedNotificationValidator();
	}

	@Override
	public Validator<? super LoanAllocationTransferFeeOwedNotification> typeFormatValidator() {
		return new LoanAllocationTransferFeeOwedNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationTransferFeeOwedNotification, Set<String>> onlyExistsValidator() {
		return new LoanAllocationTransferFeeOwedNotificationOnlyExistsValidator();
	}
}
