package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExchangeTradedOption;
import fpml.confirmation.validation.ExchangeTradedOptionTypeFormatValidator;
import fpml.confirmation.validation.ExchangeTradedOptionValidator;
import fpml.confirmation.validation.exists.ExchangeTradedOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ExchangeTradedOption.class)
public class ExchangeTradedOptionMeta implements RosettaMetaData<ExchangeTradedOption> {

	@Override
	public List<Validator<? super ExchangeTradedOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExchangeTradedOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExchangeTradedOption> validator() {
		return new ExchangeTradedOptionValidator();
	}

	@Override
	public Validator<? super ExchangeTradedOption> typeFormatValidator() {
		return new ExchangeTradedOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExchangeTradedOption, Set<String>> onlyExistsValidator() {
		return new ExchangeTradedOptionOnlyExistsValidator();
	}
}
