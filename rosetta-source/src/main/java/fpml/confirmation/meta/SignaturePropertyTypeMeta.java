package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SignaturePropertyType;
import fpml.confirmation.validation.SignaturePropertyTypeTypeFormatValidator;
import fpml.confirmation.validation.SignaturePropertyTypeValidator;
import fpml.confirmation.validation.exists.SignaturePropertyTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SignaturePropertyType.class)
public class SignaturePropertyTypeMeta implements RosettaMetaData<SignaturePropertyType> {

	@Override
	public List<Validator<? super SignaturePropertyType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SignaturePropertyType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SignaturePropertyType> validator() {
		return new SignaturePropertyTypeValidator();
	}

	@Override
	public Validator<? super SignaturePropertyType> typeFormatValidator() {
		return new SignaturePropertyTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SignaturePropertyType, Set<String>> onlyExistsValidator() {
		return new SignaturePropertyTypeOnlyExistsValidator();
	}
}
