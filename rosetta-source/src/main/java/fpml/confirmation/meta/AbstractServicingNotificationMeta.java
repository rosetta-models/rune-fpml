package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractServicingNotification;
import fpml.confirmation.validation.AbstractServicingNotificationTypeFormatValidator;
import fpml.confirmation.validation.AbstractServicingNotificationValidator;
import fpml.confirmation.validation.exists.AbstractServicingNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AbstractServicingNotification.class)
public class AbstractServicingNotificationMeta implements RosettaMetaData<AbstractServicingNotification> {

	@Override
	public List<Validator<? super AbstractServicingNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractServicingNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractServicingNotification> validator() {
		return new AbstractServicingNotificationValidator();
	}

	@Override
	public Validator<? super AbstractServicingNotification> typeFormatValidator() {
		return new AbstractServicingNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractServicingNotification, Set<String>> onlyExistsValidator() {
		return new AbstractServicingNotificationOnlyExistsValidator();
	}
}
