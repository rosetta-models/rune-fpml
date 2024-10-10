package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GenericProductQuotedCurrencyPair;
import fpml.confirmation.validation.GenericProductQuotedCurrencyPairTypeFormatValidator;
import fpml.confirmation.validation.GenericProductQuotedCurrencyPairValidator;
import fpml.confirmation.validation.exists.GenericProductQuotedCurrencyPairOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GenericProductQuotedCurrencyPair.class)
public class GenericProductQuotedCurrencyPairMeta implements RosettaMetaData<GenericProductQuotedCurrencyPair> {

	@Override
	public List<Validator<? super GenericProductQuotedCurrencyPair>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericProductQuotedCurrencyPair, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GenericProductQuotedCurrencyPair> validator() {
		return new GenericProductQuotedCurrencyPairValidator();
	}

	@Override
	public Validator<? super GenericProductQuotedCurrencyPair> typeFormatValidator() {
		return new GenericProductQuotedCurrencyPairTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericProductQuotedCurrencyPair, Set<String>> onlyExistsValidator() {
		return new GenericProductQuotedCurrencyPairOnlyExistsValidator();
	}
}
