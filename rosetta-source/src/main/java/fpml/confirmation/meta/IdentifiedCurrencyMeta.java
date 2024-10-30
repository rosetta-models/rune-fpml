package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.validation.IdentifiedCurrencyTypeFormatValidator;
import fpml.confirmation.validation.IdentifiedCurrencyValidator;
import fpml.confirmation.validation.exists.IdentifiedCurrencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=IdentifiedCurrency.class)
public class IdentifiedCurrencyMeta implements RosettaMetaData<IdentifiedCurrency> {

	@Override
	public List<Validator<? super IdentifiedCurrency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IdentifiedCurrency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super IdentifiedCurrency> validator() {
		return new IdentifiedCurrencyValidator();
	}

	@Override
	public Validator<? super IdentifiedCurrency> typeFormatValidator() {
		return new IdentifiedCurrencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IdentifiedCurrency, Set<String>> onlyExistsValidator() {
		return new IdentifiedCurrencyOnlyExistsValidator();
	}
}
