package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SwapAdditionalTerms;
import fpml.confirmation.validation.SwapAdditionalTermsTypeFormatValidator;
import fpml.confirmation.validation.SwapAdditionalTermsValidator;
import fpml.confirmation.validation.exists.SwapAdditionalTermsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SwapAdditionalTerms.class)
public class SwapAdditionalTermsMeta implements RosettaMetaData<SwapAdditionalTerms> {

	@Override
	public List<Validator<? super SwapAdditionalTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SwapAdditionalTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SwapAdditionalTerms> validator() {
		return new SwapAdditionalTermsValidator();
	}

	@Override
	public Validator<? super SwapAdditionalTerms> typeFormatValidator() {
		return new SwapAdditionalTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SwapAdditionalTerms, Set<String>> onlyExistsValidator() {
		return new SwapAdditionalTermsOnlyExistsValidator();
	}
}
