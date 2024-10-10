package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractLoanPartyProfileNotification;
import fpml.confirmation.validation.AbstractLoanPartyProfileNotificationTypeFormatValidator;
import fpml.confirmation.validation.AbstractLoanPartyProfileNotificationValidator;
import fpml.confirmation.validation.exists.AbstractLoanPartyProfileNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AbstractLoanPartyProfileNotification.class)
public class AbstractLoanPartyProfileNotificationMeta implements RosettaMetaData<AbstractLoanPartyProfileNotification> {

	@Override
	public List<Validator<? super AbstractLoanPartyProfileNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanPartyProfileNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractLoanPartyProfileNotification> validator() {
		return new AbstractLoanPartyProfileNotificationValidator();
	}

	@Override
	public Validator<? super AbstractLoanPartyProfileNotification> typeFormatValidator() {
		return new AbstractLoanPartyProfileNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanPartyProfileNotification, Set<String>> onlyExistsValidator() {
		return new AbstractLoanPartyProfileNotificationOnlyExistsValidator();
	}
}
