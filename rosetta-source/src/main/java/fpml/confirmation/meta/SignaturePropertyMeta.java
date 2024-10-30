package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SignatureProperty;
import fpml.confirmation.validation.SignaturePropertyTypeFormatValidator;
import fpml.confirmation.validation.SignaturePropertyValidator;
import fpml.confirmation.validation.exists.SignaturePropertyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SignatureProperty.class)
public class SignaturePropertyMeta implements RosettaMetaData<SignatureProperty> {

	@Override
	public List<Validator<? super SignatureProperty>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SignatureProperty, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SignatureProperty> validator() {
		return new SignaturePropertyValidator();
	}

	@Override
	public Validator<? super SignatureProperty> typeFormatValidator() {
		return new SignaturePropertyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SignatureProperty, Set<String>> onlyExistsValidator() {
		return new SignaturePropertyOnlyExistsValidator();
	}
}
