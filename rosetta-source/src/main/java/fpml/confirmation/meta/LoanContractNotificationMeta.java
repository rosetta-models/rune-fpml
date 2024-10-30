package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanContractNotification;
import fpml.confirmation.validation.LoanContractNotificationTypeFormatValidator;
import fpml.confirmation.validation.LoanContractNotificationValidator;
import fpml.confirmation.validation.exists.LoanContractNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanContractNotification.class)
public class LoanContractNotificationMeta implements RosettaMetaData<LoanContractNotification> {

	@Override
	public List<Validator<? super LoanContractNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanContractNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanContractNotification> validator() {
		return new LoanContractNotificationValidator();
	}

	@Override
	public Validator<? super LoanContractNotification> typeFormatValidator() {
		return new LoanContractNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanContractNotification, Set<String>> onlyExistsValidator() {
		return new LoanContractNotificationOnlyExistsValidator();
	}
}
