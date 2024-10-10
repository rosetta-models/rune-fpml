package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractContractNotification;
import fpml.confirmation.validation.AbstractContractNotificationTypeFormatValidator;
import fpml.confirmation.validation.AbstractContractNotificationValidator;
import fpml.confirmation.validation.exists.AbstractContractNotificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AbstractContractNotification.class)
public class AbstractContractNotificationMeta implements RosettaMetaData<AbstractContractNotification> {

	@Override
	public List<Validator<? super AbstractContractNotification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractContractNotification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractContractNotification> validator() {
		return new AbstractContractNotificationValidator();
	}

	@Override
	public Validator<? super AbstractContractNotification> typeFormatValidator() {
		return new AbstractContractNotificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractContractNotification, Set<String>> onlyExistsValidator() {
		return new AbstractContractNotificationOnlyExistsValidator();
	}
}
