package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SignaturePropertyTypeChoice;
import fpml.confirmation.validation.SignaturePropertyTypeChoiceTypeFormatValidator;
import fpml.confirmation.validation.SignaturePropertyTypeChoiceValidator;
import fpml.confirmation.validation.exists.SignaturePropertyTypeChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SignaturePropertyTypeChoice.class)
public class SignaturePropertyTypeChoiceMeta implements RosettaMetaData<SignaturePropertyTypeChoice> {

	@Override
	public List<Validator<? super SignaturePropertyTypeChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SignaturePropertyTypeChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SignaturePropertyTypeChoice> validator() {
		return new SignaturePropertyTypeChoiceValidator();
	}

	@Override
	public Validator<? super SignaturePropertyTypeChoice> typeFormatValidator() {
		return new SignaturePropertyTypeChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SignaturePropertyTypeChoice, Set<String>> onlyExistsValidator() {
		return new SignaturePropertyTypeChoiceOnlyExistsValidator();
	}
}
