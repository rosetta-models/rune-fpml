package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SignatureMethod;
import fpml.confirmation.validation.SignatureMethodTypeFormatValidator;
import fpml.confirmation.validation.SignatureMethodValidator;
import fpml.confirmation.validation.exists.SignatureMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SignatureMethod.class)
public class SignatureMethodMeta implements RosettaMetaData<SignatureMethod> {

	@Override
	public List<Validator<? super SignatureMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SignatureMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SignatureMethod> validator() {
		return new SignatureMethodValidator();
	}

	@Override
	public Validator<? super SignatureMethod> typeFormatValidator() {
		return new SignatureMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SignatureMethod, Set<String>> onlyExistsValidator() {
		return new SignatureMethodOnlyExistsValidator();
	}
}
