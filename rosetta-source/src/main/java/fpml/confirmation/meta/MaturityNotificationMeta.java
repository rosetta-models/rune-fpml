package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MaturityNotification;
import fpml.confirmation.validation.MaturityNotificationTypeFormatValidator;
import fpml.confirmation.validation.MaturityNotificationValidator;
import fpml.confirmation.validation.exists.MaturityNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MaturityNotification.class)
public class MaturityNotificationMeta implements RosettaMetaData<MaturityNotification> {

	@Override
	public List<Validator<? super MaturityNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.MaturityNotification>create(fpml.confirmation.validation.datarule.MaturityNotificationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super MaturityNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MaturityNotification> validator() {
		return new MaturityNotificationValidator();
	}

	@Override
	public Validator<? super MaturityNotification> typeFormatValidator() {
		return new MaturityNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MaturityNotification, Set<String>> onlyExistsValidator() {
		return new MaturityNotificationOnlyExistsValidator();
	}
}
