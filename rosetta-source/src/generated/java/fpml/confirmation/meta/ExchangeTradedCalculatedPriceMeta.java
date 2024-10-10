package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExchangeTradedCalculatedPrice;
import fpml.confirmation.validation.ExchangeTradedCalculatedPriceTypeFormatValidator;
import fpml.confirmation.validation.ExchangeTradedCalculatedPriceValidator;
import fpml.confirmation.validation.exists.ExchangeTradedCalculatedPriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ExchangeTradedCalculatedPrice.class)
public class ExchangeTradedCalculatedPriceMeta implements RosettaMetaData<ExchangeTradedCalculatedPrice> {

	@Override
	public List<Validator<? super ExchangeTradedCalculatedPrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExchangeTradedCalculatedPrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExchangeTradedCalculatedPrice> validator() {
		return new ExchangeTradedCalculatedPriceValidator();
	}

	@Override
	public Validator<? super ExchangeTradedCalculatedPrice> typeFormatValidator() {
		return new ExchangeTradedCalculatedPriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExchangeTradedCalculatedPrice, Set<String>> onlyExistsValidator() {
		return new ExchangeTradedCalculatedPriceOnlyExistsValidator();
	}
}
