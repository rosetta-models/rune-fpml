package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DualCurrencyStrikePrice;
import fpml.confirmation.validation.DualCurrencyStrikePriceTypeFormatValidator;
import fpml.confirmation.validation.DualCurrencyStrikePriceValidator;
import fpml.confirmation.validation.exists.DualCurrencyStrikePriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DualCurrencyStrikePrice.class)
public class DualCurrencyStrikePriceMeta implements RosettaMetaData<DualCurrencyStrikePrice> {

	@Override
	public List<Validator<? super DualCurrencyStrikePrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DualCurrencyStrikePrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DualCurrencyStrikePrice> validator() {
		return new DualCurrencyStrikePriceValidator();
	}

	@Override
	public Validator<? super DualCurrencyStrikePrice> typeFormatValidator() {
		return new DualCurrencyStrikePriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DualCurrencyStrikePrice, Set<String>> onlyExistsValidator() {
		return new DualCurrencyStrikePriceOnlyExistsValidator();
	}
}
