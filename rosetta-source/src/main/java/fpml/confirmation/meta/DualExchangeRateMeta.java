package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DualExchangeRate;
import fpml.confirmation.validation.DualExchangeRateTypeFormatValidator;
import fpml.confirmation.validation.DualExchangeRateValidator;
import fpml.confirmation.validation.exists.DualExchangeRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DualExchangeRate.class)
public class DualExchangeRateMeta implements RosettaMetaData<DualExchangeRate> {

	@Override
	public List<Validator<? super DualExchangeRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DualExchangeRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DualExchangeRate> validator() {
		return new DualExchangeRateValidator();
	}

	@Override
	public Validator<? super DualExchangeRate> typeFormatValidator() {
		return new DualExchangeRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DualExchangeRate, Set<String>> onlyExistsValidator() {
		return new DualExchangeRateOnlyExistsValidator();
	}
}
