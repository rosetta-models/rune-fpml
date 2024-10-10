package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.VerificationMethod;
import fpml.confirmation.validation.VerificationMethodTypeFormatValidator;
import fpml.confirmation.validation.VerificationMethodValidator;
import fpml.confirmation.validation.exists.VerificationMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=VerificationMethod.class)
public class VerificationMethodMeta implements RosettaMetaData<VerificationMethod> {

	@Override
	public List<Validator<? super VerificationMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VerificationMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super VerificationMethod> validator() {
		return new VerificationMethodValidator();
	}

	@Override
	public Validator<? super VerificationMethod> typeFormatValidator() {
		return new VerificationMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VerificationMethod, Set<String>> onlyExistsValidator() {
		return new VerificationMethodOnlyExistsValidator();
	}
}
