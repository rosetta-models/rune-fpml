package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccrualOptionChangeNotification;
import fpml.confirmation.validation.AccrualOptionChangeNotificationTypeFormatValidator;
import fpml.confirmation.validation.AccrualOptionChangeNotificationValidator;
import fpml.confirmation.validation.exists.AccrualOptionChangeNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AccrualOptionChangeNotification.class)
public class AccrualOptionChangeNotificationMeta implements RosettaMetaData<AccrualOptionChangeNotification> {

	@Override
	public List<Validator<? super AccrualOptionChangeNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.AccrualOptionChangeNotification>create(fpml.confirmation.validation.datarule.AccrualOptionChangeNotificationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AccrualOptionChangeNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccrualOptionChangeNotification> validator() {
		return new AccrualOptionChangeNotificationValidator();
	}

	@Override
	public Validator<? super AccrualOptionChangeNotification> typeFormatValidator() {
		return new AccrualOptionChangeNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccrualOptionChangeNotification, Set<String>> onlyExistsValidator() {
		return new AccrualOptionChangeNotificationOnlyExistsValidator();
	}
}
