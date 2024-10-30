package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractFacilityNotification;
import fpml.confirmation.validation.AbstractFacilityNotificationTypeFormatValidator;
import fpml.confirmation.validation.AbstractFacilityNotificationValidator;
import fpml.confirmation.validation.exists.AbstractFacilityNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AbstractFacilityNotification.class)
public class AbstractFacilityNotificationMeta implements RosettaMetaData<AbstractFacilityNotification> {

	@Override
	public List<Validator<? super AbstractFacilityNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractFacilityNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractFacilityNotification> validator() {
		return new AbstractFacilityNotificationValidator();
	}

	@Override
	public Validator<? super AbstractFacilityNotification> typeFormatValidator() {
		return new AbstractFacilityNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractFacilityNotification, Set<String>> onlyExistsValidator() {
		return new AbstractFacilityNotificationOnlyExistsValidator();
	}
}
