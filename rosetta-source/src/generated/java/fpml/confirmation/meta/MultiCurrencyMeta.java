package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MultiCurrency;
import fpml.confirmation.validation.MultiCurrencyTypeFormatValidator;
import fpml.confirmation.validation.MultiCurrencyValidator;
import fpml.confirmation.validation.exists.MultiCurrencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MultiCurrency.class)
public class MultiCurrencyMeta implements RosettaMetaData<MultiCurrency> {

	@Override
	public List<Validator<? super MultiCurrency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MultiCurrency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MultiCurrency> validator() {
		return new MultiCurrencyValidator();
	}

	@Override
	public Validator<? super MultiCurrency> typeFormatValidator() {
		return new MultiCurrencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MultiCurrency, Set<String>> onlyExistsValidator() {
		return new MultiCurrencyOnlyExistsValidator();
	}
}
