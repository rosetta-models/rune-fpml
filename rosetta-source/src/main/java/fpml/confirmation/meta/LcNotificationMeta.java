package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LcNotification;
import fpml.confirmation.validation.LcNotificationTypeFormatValidator;
import fpml.confirmation.validation.LcNotificationValidator;
import fpml.confirmation.validation.exists.LcNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LcNotification.class)
public class LcNotificationMeta implements RosettaMetaData<LcNotification> {

	@Override
	public List<Validator<? super LcNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LcNotification> validator() {
		return new LcNotificationValidator();
	}

	@Override
	public Validator<? super LcNotification> typeFormatValidator() {
		return new LcNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcNotification, Set<String>> onlyExistsValidator() {
		return new LcNotificationOnlyExistsValidator();
	}
}
