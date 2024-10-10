package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityNotification;
import fpml.confirmation.validation.FacilityNotificationTypeFormatValidator;
import fpml.confirmation.validation.FacilityNotificationValidator;
import fpml.confirmation.validation.exists.FacilityNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityNotification.class)
public class FacilityNotificationMeta implements RosettaMetaData<FacilityNotification> {

	@Override
	public List<Validator<? super FacilityNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityNotification> validator() {
		return new FacilityNotificationValidator();
	}

	@Override
	public Validator<? super FacilityNotification> typeFormatValidator() {
		return new FacilityNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityNotification, Set<String>> onlyExistsValidator() {
		return new FacilityNotificationOnlyExistsValidator();
	}
}
