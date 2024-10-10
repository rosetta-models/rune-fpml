package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RequestConfirmation;
import fpml.confirmation.validation.RequestConfirmationTypeFormatValidator;
import fpml.confirmation.validation.RequestConfirmationValidator;
import fpml.confirmation.validation.exists.RequestConfirmationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=RequestConfirmation.class)
public class RequestConfirmationMeta implements RosettaMetaData<RequestConfirmation> {

	@Override
	public List<Validator<? super RequestConfirmation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.RequestConfirmation>create(fpml.confirmation.validation.datarule.RequestConfirmationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RequestConfirmation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RequestConfirmation> validator() {
		return new RequestConfirmationValidator();
	}

	@Override
	public Validator<? super RequestConfirmation> typeFormatValidator() {
		return new RequestConfirmationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestConfirmation, Set<String>> onlyExistsValidator() {
		return new RequestConfirmationOnlyExistsValidator();
	}
}
