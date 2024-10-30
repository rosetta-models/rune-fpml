package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GeneralTerms;
import fpml.confirmation.validation.GeneralTermsTypeFormatValidator;
import fpml.confirmation.validation.GeneralTermsValidator;
import fpml.confirmation.validation.exists.GeneralTermsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=GeneralTerms.class)
public class GeneralTermsMeta implements RosettaMetaData<GeneralTerms> {

	@Override
	public List<Validator<? super GeneralTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.GeneralTerms>create(fpml.confirmation.validation.datarule.GeneralTermsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super GeneralTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GeneralTerms> validator() {
		return new GeneralTermsValidator();
	}

	@Override
	public Validator<? super GeneralTerms> typeFormatValidator() {
		return new GeneralTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GeneralTerms, Set<String>> onlyExistsValidator() {
		return new GeneralTermsOnlyExistsValidator();
	}
}
