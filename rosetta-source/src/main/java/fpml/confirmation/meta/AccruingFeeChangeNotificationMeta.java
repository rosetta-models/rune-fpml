package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccruingFeeChangeNotification;
import fpml.confirmation.validation.AccruingFeeChangeNotificationTypeFormatValidator;
import fpml.confirmation.validation.AccruingFeeChangeNotificationValidator;
import fpml.confirmation.validation.exists.AccruingFeeChangeNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AccruingFeeChangeNotification.class)
public class AccruingFeeChangeNotificationMeta implements RosettaMetaData<AccruingFeeChangeNotification> {

	@Override
	public List<Validator<? super AccruingFeeChangeNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccruingFeeChangeNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccruingFeeChangeNotification> validator() {
		return new AccruingFeeChangeNotificationValidator();
	}

	@Override
	public Validator<? super AccruingFeeChangeNotification> typeFormatValidator() {
		return new AccruingFeeChangeNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccruingFeeChangeNotification, Set<String>> onlyExistsValidator() {
		return new AccruingFeeChangeNotificationOnlyExistsValidator();
	}
}
