package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExchangeTradedContractUnderlyer;
import fpml.confirmation.validation.ExchangeTradedContractUnderlyerTypeFormatValidator;
import fpml.confirmation.validation.ExchangeTradedContractUnderlyerValidator;
import fpml.confirmation.validation.exists.ExchangeTradedContractUnderlyerOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ExchangeTradedContractUnderlyer.class)
public class ExchangeTradedContractUnderlyerMeta implements RosettaMetaData<ExchangeTradedContractUnderlyer> {

	@Override
	public List<Validator<? super ExchangeTradedContractUnderlyer>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ExchangeTradedContractUnderlyer>create(fpml.confirmation.validation.datarule.ExchangeTradedContractUnderlyerChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ExchangeTradedContractUnderlyer, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExchangeTradedContractUnderlyer> validator() {
		return new ExchangeTradedContractUnderlyerValidator();
	}

	@Override
	public Validator<? super ExchangeTradedContractUnderlyer> typeFormatValidator() {
		return new ExchangeTradedContractUnderlyerTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExchangeTradedContractUnderlyer, Set<String>> onlyExistsValidator() {
		return new ExchangeTradedContractUnderlyerOnlyExistsValidator();
	}
}
