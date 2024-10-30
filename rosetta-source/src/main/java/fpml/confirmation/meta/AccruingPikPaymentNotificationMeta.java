package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccruingPikPaymentNotification;
import fpml.confirmation.validation.AccruingPikPaymentNotificationTypeFormatValidator;
import fpml.confirmation.validation.AccruingPikPaymentNotificationValidator;
import fpml.confirmation.validation.exists.AccruingPikPaymentNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AccruingPikPaymentNotification.class)
public class AccruingPikPaymentNotificationMeta implements RosettaMetaData<AccruingPikPaymentNotification> {

	@Override
	public List<Validator<? super AccruingPikPaymentNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccruingPikPaymentNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccruingPikPaymentNotification> validator() {
		return new AccruingPikPaymentNotificationValidator();
	}

	@Override
	public Validator<? super AccruingPikPaymentNotification> typeFormatValidator() {
		return new AccruingPikPaymentNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccruingPikPaymentNotification, Set<String>> onlyExistsValidator() {
		return new AccruingPikPaymentNotificationOnlyExistsValidator();
	}
}
