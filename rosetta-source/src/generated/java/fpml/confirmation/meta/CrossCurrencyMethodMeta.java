package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CrossCurrencyMethod;
import fpml.confirmation.validation.CrossCurrencyMethodTypeFormatValidator;
import fpml.confirmation.validation.CrossCurrencyMethodValidator;
import fpml.confirmation.validation.exists.CrossCurrencyMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CrossCurrencyMethod.class)
public class CrossCurrencyMethodMeta implements RosettaMetaData<CrossCurrencyMethod> {

	@Override
	public List<Validator<? super CrossCurrencyMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CrossCurrencyMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CrossCurrencyMethod> validator() {
		return new CrossCurrencyMethodValidator();
	}

	@Override
	public Validator<? super CrossCurrencyMethod> typeFormatValidator() {
		return new CrossCurrencyMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CrossCurrencyMethod, Set<String>> onlyExistsValidator() {
		return new CrossCurrencyMethodOnlyExistsValidator();
	}
}
