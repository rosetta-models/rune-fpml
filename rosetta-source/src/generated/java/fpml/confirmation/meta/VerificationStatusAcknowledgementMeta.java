package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.VerificationStatusAcknowledgement;
import fpml.confirmation.validation.VerificationStatusAcknowledgementTypeFormatValidator;
import fpml.confirmation.validation.VerificationStatusAcknowledgementValidator;
import fpml.confirmation.validation.exists.VerificationStatusAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=VerificationStatusAcknowledgement.class)
public class VerificationStatusAcknowledgementMeta implements RosettaMetaData<VerificationStatusAcknowledgement> {

	@Override
	public List<Validator<? super VerificationStatusAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VerificationStatusAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super VerificationStatusAcknowledgement> validator() {
		return new VerificationStatusAcknowledgementValidator();
	}

	@Override
	public Validator<? super VerificationStatusAcknowledgement> typeFormatValidator() {
		return new VerificationStatusAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VerificationStatusAcknowledgement, Set<String>> onlyExistsValidator() {
		return new VerificationStatusAcknowledgementOnlyExistsValidator();
	}
}
