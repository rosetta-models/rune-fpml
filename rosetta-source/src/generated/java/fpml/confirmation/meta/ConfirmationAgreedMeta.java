package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ConfirmationAgreed;
import fpml.confirmation.validation.ConfirmationAgreedTypeFormatValidator;
import fpml.confirmation.validation.ConfirmationAgreedValidator;
import fpml.confirmation.validation.exists.ConfirmationAgreedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ConfirmationAgreed.class)
public class ConfirmationAgreedMeta implements RosettaMetaData<ConfirmationAgreed> {

	@Override
	public List<Validator<? super ConfirmationAgreed>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ConfirmationAgreed>create(fpml.confirmation.validation.datarule.ConfirmationAgreedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ConfirmationAgreed, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ConfirmationAgreed> validator() {
		return new ConfirmationAgreedValidator();
	}

	@Override
	public Validator<? super ConfirmationAgreed> typeFormatValidator() {
		return new ConfirmationAgreedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConfirmationAgreed, Set<String>> onlyExistsValidator() {
		return new ConfirmationAgreedOnlyExistsValidator();
	}
}
