package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ApprovalStatusNotification;
import fpml.confirmation.validation.ApprovalStatusNotificationTypeFormatValidator;
import fpml.confirmation.validation.ApprovalStatusNotificationValidator;
import fpml.confirmation.validation.exists.ApprovalStatusNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ApprovalStatusNotification.class)
public class ApprovalStatusNotificationMeta implements RosettaMetaData<ApprovalStatusNotification> {

	@Override
	public List<Validator<? super ApprovalStatusNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ApprovalStatusNotification>create(fpml.confirmation.validation.datarule.ApprovalStatusNotificationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ApprovalStatusNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ApprovalStatusNotification> validator() {
		return new ApprovalStatusNotificationValidator();
	}

	@Override
	public Validator<? super ApprovalStatusNotification> typeFormatValidator() {
		return new ApprovalStatusNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApprovalStatusNotification, Set<String>> onlyExistsValidator() {
		return new ApprovalStatusNotificationOnlyExistsValidator();
	}
}
