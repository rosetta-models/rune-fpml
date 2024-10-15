package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTransferNotification;
import fpml.confirmation.validation.LoanTransferNotificationTypeFormatValidator;
import fpml.confirmation.validation.LoanTransferNotificationValidator;
import fpml.confirmation.validation.exists.LoanTransferNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTransferNotification.class)
public class LoanTransferNotificationMeta implements RosettaMetaData<LoanTransferNotification> {

	@Override
	public List<Validator<? super LoanTransferNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTransferNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTransferNotification> validator() {
		return new LoanTransferNotificationValidator();
	}

	@Override
	public Validator<? super LoanTransferNotification> typeFormatValidator() {
		return new LoanTransferNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTransferNotification, Set<String>> onlyExistsValidator() {
		return new LoanTransferNotificationOnlyExistsValidator();
	}
}
