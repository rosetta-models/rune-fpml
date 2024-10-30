package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InstrumentTradePricing;
import fpml.confirmation.validation.InstrumentTradePricingTypeFormatValidator;
import fpml.confirmation.validation.InstrumentTradePricingValidator;
import fpml.confirmation.validation.exists.InstrumentTradePricingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=InstrumentTradePricing.class)
public class InstrumentTradePricingMeta implements RosettaMetaData<InstrumentTradePricing> {

	@Override
	public List<Validator<? super InstrumentTradePricing>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InstrumentTradePricing, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InstrumentTradePricing> validator() {
		return new InstrumentTradePricingValidator();
	}

	@Override
	public Validator<? super InstrumentTradePricing> typeFormatValidator() {
		return new InstrumentTradePricingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InstrumentTradePricing, Set<String>> onlyExistsValidator() {
		return new InstrumentTradePricingOnlyExistsValidator();
	}
}
