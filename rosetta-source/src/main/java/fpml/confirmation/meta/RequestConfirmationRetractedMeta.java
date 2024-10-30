package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RequestConfirmationRetracted;
import fpml.confirmation.validation.RequestConfirmationRetractedTypeFormatValidator;
import fpml.confirmation.validation.RequestConfirmationRetractedValidator;
import fpml.confirmation.validation.exists.RequestConfirmationRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RequestConfirmationRetracted.class)
public class RequestConfirmationRetractedMeta implements RosettaMetaData<RequestConfirmationRetracted> {

	@Override
	public List<Validator<? super RequestConfirmationRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ConfirmationRetracted>create(fpml.confirmation.validation.datarule.ConfirmationRetractedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RequestConfirmationRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RequestConfirmationRetracted> validator() {
		return new RequestConfirmationRetractedValidator();
	}

	@Override
	public Validator<? super RequestConfirmationRetracted> typeFormatValidator() {
		return new RequestConfirmationRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestConfirmationRetracted, Set<String>> onlyExistsValidator() {
		return new RequestConfirmationRetractedOnlyExistsValidator();
	}
}
