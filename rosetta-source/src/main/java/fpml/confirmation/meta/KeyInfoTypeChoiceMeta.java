package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.KeyInfoTypeChoice;
import fpml.confirmation.validation.KeyInfoTypeChoiceTypeFormatValidator;
import fpml.confirmation.validation.KeyInfoTypeChoiceValidator;
import fpml.confirmation.validation.exists.KeyInfoTypeChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=KeyInfoTypeChoice.class)
public class KeyInfoTypeChoiceMeta implements RosettaMetaData<KeyInfoTypeChoice> {

	@Override
	public List<Validator<? super KeyInfoTypeChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.KeyInfoTypeChoice>create(fpml.confirmation.validation.datarule.KeyInfoTypeChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super KeyInfoTypeChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super KeyInfoTypeChoice> validator() {
		return new KeyInfoTypeChoiceValidator();
	}

	@Override
	public Validator<? super KeyInfoTypeChoice> typeFormatValidator() {
		return new KeyInfoTypeChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super KeyInfoTypeChoice, Set<String>> onlyExistsValidator() {
		return new KeyInfoTypeChoiceOnlyExistsValidator();
	}
}
