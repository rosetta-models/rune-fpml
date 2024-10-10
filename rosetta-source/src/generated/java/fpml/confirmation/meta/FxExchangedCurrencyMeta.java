package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxExchangedCurrency;
import fpml.confirmation.validation.FxExchangedCurrencyTypeFormatValidator;
import fpml.confirmation.validation.FxExchangedCurrencyValidator;
import fpml.confirmation.validation.exists.FxExchangedCurrencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxExchangedCurrency.class)
public class FxExchangedCurrencyMeta implements RosettaMetaData<FxExchangedCurrency> {

	@Override
	public List<Validator<? super FxExchangedCurrency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxExchangedCurrency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxExchangedCurrency> validator() {
		return new FxExchangedCurrencyValidator();
	}

	@Override
	public Validator<? super FxExchangedCurrency> typeFormatValidator() {
		return new FxExchangedCurrencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxExchangedCurrency, Set<String>> onlyExistsValidator() {
		return new FxExchangedCurrencyOnlyExistsValidator();
	}
}
