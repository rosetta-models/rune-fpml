package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SignaturePropertiesType;
import fpml.confirmation.validation.SignaturePropertiesTypeTypeFormatValidator;
import fpml.confirmation.validation.SignaturePropertiesTypeValidator;
import fpml.confirmation.validation.exists.SignaturePropertiesTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SignaturePropertiesType.class)
public class SignaturePropertiesTypeMeta implements RosettaMetaData<SignaturePropertiesType> {

	@Override
	public List<Validator<? super SignaturePropertiesType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SignaturePropertiesType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SignaturePropertiesType> validator() {
		return new SignaturePropertiesTypeValidator();
	}

	@Override
	public Validator<? super SignaturePropertiesType> typeFormatValidator() {
		return new SignaturePropertiesTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SignaturePropertiesType, Set<String>> onlyExistsValidator() {
		return new SignaturePropertiesTypeOnlyExistsValidator();
	}
}
