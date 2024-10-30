package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SignatureMethodType;
import fpml.confirmation.validation.SignatureMethodTypeTypeFormatValidator;
import fpml.confirmation.validation.SignatureMethodTypeValidator;
import fpml.confirmation.validation.exists.SignatureMethodTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SignatureMethodType.class)
public class SignatureMethodTypeMeta implements RosettaMetaData<SignatureMethodType> {

	@Override
	public List<Validator<? super SignatureMethodType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SignatureMethodType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SignatureMethodType> validator() {
		return new SignatureMethodTypeValidator();
	}

	@Override
	public Validator<? super SignatureMethodType> typeFormatValidator() {
		return new SignatureMethodTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SignatureMethodType, Set<String>> onlyExistsValidator() {
		return new SignatureMethodTypeOnlyExistsValidator();
	}
}
