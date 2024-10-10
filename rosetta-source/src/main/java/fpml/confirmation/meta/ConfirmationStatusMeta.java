package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ConfirmationStatus;
import fpml.confirmation.validation.ConfirmationStatusTypeFormatValidator;
import fpml.confirmation.validation.ConfirmationStatusValidator;
import fpml.confirmation.validation.exists.ConfirmationStatusOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ConfirmationStatus.class)
public class ConfirmationStatusMeta implements RosettaMetaData<ConfirmationStatus> {

	@Override
	public List<Validator<? super ConfirmationStatus>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ConfirmationStatus>create(fpml.confirmation.validation.datarule.ConfirmationStatusChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ConfirmationStatus, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ConfirmationStatus> validator() {
		return new ConfirmationStatusValidator();
	}

	@Override
	public Validator<? super ConfirmationStatus> typeFormatValidator() {
		return new ConfirmationStatusTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConfirmationStatus, Set<String>> onlyExistsValidator() {
		return new ConfirmationStatusOnlyExistsValidator();
	}
}
