package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Signature;
import fpml.confirmation.validation.SignatureTypeFormatValidator;
import fpml.confirmation.validation.SignatureValidator;
import fpml.confirmation.validation.exists.SignatureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Signature.class)
public class SignatureMeta implements RosettaMetaData<Signature> {

	@Override
	public List<Validator<? super Signature>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Signature, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Signature> validator() {
		return new SignatureValidator();
	}

	@Override
	public Validator<? super Signature> typeFormatValidator() {
		return new SignatureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Signature, Set<String>> onlyExistsValidator() {
		return new SignatureOnlyExistsValidator();
	}
}
