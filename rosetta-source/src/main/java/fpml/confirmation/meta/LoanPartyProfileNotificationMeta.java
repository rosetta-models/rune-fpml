package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanPartyProfileNotification;
import fpml.confirmation.validation.LoanPartyProfileNotificationTypeFormatValidator;
import fpml.confirmation.validation.LoanPartyProfileNotificationValidator;
import fpml.confirmation.validation.exists.LoanPartyProfileNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanPartyProfileNotification.class)
public class LoanPartyProfileNotificationMeta implements RosettaMetaData<LoanPartyProfileNotification> {

	@Override
	public List<Validator<? super LoanPartyProfileNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanPartyProfileNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanPartyProfileNotification> validator() {
		return new LoanPartyProfileNotificationValidator();
	}

	@Override
	public Validator<? super LoanPartyProfileNotification> typeFormatValidator() {
		return new LoanPartyProfileNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanPartyProfileNotification, Set<String>> onlyExistsValidator() {
		return new LoanPartyProfileNotificationOnlyExistsValidator();
	}
}
