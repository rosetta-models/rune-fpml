package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExchangeTraded;
import fpml.confirmation.validation.ExchangeTradedTypeFormatValidator;
import fpml.confirmation.validation.ExchangeTradedValidator;
import fpml.confirmation.validation.exists.ExchangeTradedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ExchangeTraded.class)
public class ExchangeTradedMeta implements RosettaMetaData<ExchangeTraded> {

	@Override
	public List<Validator<? super ExchangeTraded>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExchangeTraded, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExchangeTraded> validator() {
		return new ExchangeTradedValidator();
	}

	@Override
	public Validator<? super ExchangeTraded> typeFormatValidator() {
		return new ExchangeTradedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExchangeTraded, Set<String>> onlyExistsValidator() {
		return new ExchangeTradedOnlyExistsValidator();
	}
}
