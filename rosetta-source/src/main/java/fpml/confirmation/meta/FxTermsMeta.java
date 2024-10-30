package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTerms;
import fpml.confirmation.validation.FxTermsTypeFormatValidator;
import fpml.confirmation.validation.FxTermsValidator;
import fpml.confirmation.validation.exists.FxTermsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxTerms.class)
public class FxTermsMeta implements RosettaMetaData<FxTerms> {

	@Override
	public List<Validator<? super FxTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTerms> validator() {
		return new FxTermsValidator();
	}

	@Override
	public Validator<? super FxTerms> typeFormatValidator() {
		return new FxTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTerms, Set<String>> onlyExistsValidator() {
		return new FxTermsOnlyExistsValidator();
	}
}
