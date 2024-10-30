package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxForwardStrikePrice;
import fpml.confirmation.validation.FxForwardStrikePriceTypeFormatValidator;
import fpml.confirmation.validation.FxForwardStrikePriceValidator;
import fpml.confirmation.validation.exists.FxForwardStrikePriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxForwardStrikePrice.class)
public class FxForwardStrikePriceMeta implements RosettaMetaData<FxForwardStrikePrice> {

	@Override
	public List<Validator<? super FxForwardStrikePrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxForwardStrikePrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxForwardStrikePrice> validator() {
		return new FxForwardStrikePriceValidator();
	}

	@Override
	public Validator<? super FxForwardStrikePrice> typeFormatValidator() {
		return new FxForwardStrikePriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxForwardStrikePrice, Set<String>> onlyExistsValidator() {
		return new FxForwardStrikePriceOnlyExistsValidator();
	}
}
