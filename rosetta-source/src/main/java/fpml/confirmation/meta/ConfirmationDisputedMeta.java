package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ConfirmationDisputed;
import fpml.confirmation.validation.ConfirmationDisputedTypeFormatValidator;
import fpml.confirmation.validation.ConfirmationDisputedValidator;
import fpml.confirmation.validation.exists.ConfirmationDisputedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ConfirmationDisputed.class)
public class ConfirmationDisputedMeta implements RosettaMetaData<ConfirmationDisputed> {

	@Override
	public List<Validator<? super ConfirmationDisputed>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ConfirmationDisputed>create(fpml.confirmation.validation.datarule.ConfirmationDisputedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ConfirmationDisputed, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ConfirmationDisputed> validator() {
		return new ConfirmationDisputedValidator();
	}

	@Override
	public Validator<? super ConfirmationDisputed> typeFormatValidator() {
		return new ConfirmationDisputedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConfirmationDisputed, Set<String>> onlyExistsValidator() {
		return new ConfirmationDisputedOnlyExistsValidator();
	}
}
