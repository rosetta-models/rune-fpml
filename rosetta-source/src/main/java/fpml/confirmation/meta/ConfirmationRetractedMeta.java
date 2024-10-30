package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ConfirmationRetracted;
import fpml.confirmation.validation.ConfirmationRetractedTypeFormatValidator;
import fpml.confirmation.validation.ConfirmationRetractedValidator;
import fpml.confirmation.validation.exists.ConfirmationRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ConfirmationRetracted.class)
public class ConfirmationRetractedMeta implements RosettaMetaData<ConfirmationRetracted> {

	@Override
	public List<Validator<? super ConfirmationRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ConfirmationRetracted>create(fpml.confirmation.validation.datarule.ConfirmationRetractedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ConfirmationRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ConfirmationRetracted> validator() {
		return new ConfirmationRetractedValidator();
	}

	@Override
	public Validator<? super ConfirmationRetracted> typeFormatValidator() {
		return new ConfirmationRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConfirmationRetracted, Set<String>> onlyExistsValidator() {
		return new ConfirmationRetractedOnlyExistsValidator();
	}
}
