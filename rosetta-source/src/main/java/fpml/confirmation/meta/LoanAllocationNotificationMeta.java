package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanAllocationNotification;
import fpml.confirmation.validation.LoanAllocationNotificationTypeFormatValidator;
import fpml.confirmation.validation.LoanAllocationNotificationValidator;
import fpml.confirmation.validation.exists.LoanAllocationNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanAllocationNotification.class)
public class LoanAllocationNotificationMeta implements RosettaMetaData<LoanAllocationNotification> {

	@Override
	public List<Validator<? super LoanAllocationNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanAllocationNotification> validator() {
		return new LoanAllocationNotificationValidator();
	}

	@Override
	public Validator<? super LoanAllocationNotification> typeFormatValidator() {
		return new LoanAllocationNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationNotification, Set<String>> onlyExistsValidator() {
		return new LoanAllocationNotificationOnlyExistsValidator();
	}
}
