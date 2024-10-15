package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Language;
import fpml.confirmation.validation.LanguageTypeFormatValidator;
import fpml.confirmation.validation.LanguageValidator;
import fpml.confirmation.validation.exists.LanguageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Language.class)
public class LanguageMeta implements RosettaMetaData<Language> {

	@Override
	public List<Validator<? super Language>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Language, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Language> validator() {
		return new LanguageValidator();
	}

	@Override
	public Validator<? super Language> typeFormatValidator() {
		return new LanguageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Language, Set<String>> onlyExistsValidator() {
		return new LanguageOnlyExistsValidator();
	}
}
