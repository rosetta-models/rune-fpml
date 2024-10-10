package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GenericProductExchangeRate;
import fpml.confirmation.validation.GenericProductExchangeRateTypeFormatValidator;
import fpml.confirmation.validation.GenericProductExchangeRateValidator;
import fpml.confirmation.validation.exists.GenericProductExchangeRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GenericProductExchangeRate.class)
public class GenericProductExchangeRateMeta implements RosettaMetaData<GenericProductExchangeRate> {

	@Override
	public List<Validator<? super GenericProductExchangeRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericProductExchangeRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GenericProductExchangeRate> validator() {
		return new GenericProductExchangeRateValidator();
	}

	@Override
	public Validator<? super GenericProductExchangeRate> typeFormatValidator() {
		return new GenericProductExchangeRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericProductExchangeRate, Set<String>> onlyExistsValidator() {
		return new GenericProductExchangeRateOnlyExistsValidator();
	}
}
