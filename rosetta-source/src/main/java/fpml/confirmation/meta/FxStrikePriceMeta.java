package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxStrikePrice;
import fpml.confirmation.validation.FxStrikePriceTypeFormatValidator;
import fpml.confirmation.validation.FxStrikePriceValidator;
import fpml.confirmation.validation.exists.FxStrikePriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxStrikePrice.class)
public class FxStrikePriceMeta implements RosettaMetaData<FxStrikePrice> {

	@Override
	public List<Validator<? super FxStrikePrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxStrikePrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxStrikePrice> validator() {
		return new FxStrikePriceValidator();
	}

	@Override
	public Validator<? super FxStrikePrice> typeFormatValidator() {
		return new FxStrikePriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxStrikePrice, Set<String>> onlyExistsValidator() {
		return new FxStrikePriceOnlyExistsValidator();
	}
}
