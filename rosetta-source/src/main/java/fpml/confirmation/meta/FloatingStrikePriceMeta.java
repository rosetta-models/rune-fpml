package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FloatingStrikePrice;
import fpml.confirmation.validation.FloatingStrikePriceTypeFormatValidator;
import fpml.confirmation.validation.FloatingStrikePriceValidator;
import fpml.confirmation.validation.exists.FloatingStrikePriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FloatingStrikePrice.class)
public class FloatingStrikePriceMeta implements RosettaMetaData<FloatingStrikePrice> {

	@Override
	public List<Validator<? super FloatingStrikePrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FloatingLegCalculation>create(fpml.confirmation.validation.datarule.FloatingLegCalculationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FloatingStrikePrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FloatingStrikePrice> validator() {
		return new FloatingStrikePriceValidator();
	}

	@Override
	public Validator<? super FloatingStrikePrice> typeFormatValidator() {
		return new FloatingStrikePriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingStrikePrice, Set<String>> onlyExistsValidator() {
		return new FloatingStrikePriceOnlyExistsValidator();
	}
}
