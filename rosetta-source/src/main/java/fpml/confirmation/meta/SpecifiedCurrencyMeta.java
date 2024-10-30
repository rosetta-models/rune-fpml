package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SpecifiedCurrency;
import fpml.confirmation.validation.SpecifiedCurrencyTypeFormatValidator;
import fpml.confirmation.validation.SpecifiedCurrencyValidator;
import fpml.confirmation.validation.exists.SpecifiedCurrencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SpecifiedCurrency.class)
public class SpecifiedCurrencyMeta implements RosettaMetaData<SpecifiedCurrency> {

	@Override
	public List<Validator<? super SpecifiedCurrency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SpecifiedCurrency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SpecifiedCurrency> validator() {
		return new SpecifiedCurrencyValidator();
	}

	@Override
	public Validator<? super SpecifiedCurrency> typeFormatValidator() {
		return new SpecifiedCurrencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SpecifiedCurrency, Set<String>> onlyExistsValidator() {
		return new SpecifiedCurrencyOnlyExistsValidator();
	}
}
