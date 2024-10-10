package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityRateChangeNotification;
import fpml.confirmation.validation.FacilityRateChangeNotificationTypeFormatValidator;
import fpml.confirmation.validation.FacilityRateChangeNotificationValidator;
import fpml.confirmation.validation.exists.FacilityRateChangeNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityRateChangeNotification.class)
public class FacilityRateChangeNotificationMeta implements RosettaMetaData<FacilityRateChangeNotification> {

	@Override
	public List<Validator<? super FacilityRateChangeNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityRateChangeNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityRateChangeNotification> validator() {
		return new FacilityRateChangeNotificationValidator();
	}

	@Override
	public Validator<? super FacilityRateChangeNotification> typeFormatValidator() {
		return new FacilityRateChangeNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityRateChangeNotification, Set<String>> onlyExistsValidator() {
		return new FacilityRateChangeNotificationOnlyExistsValidator();
	}
}
