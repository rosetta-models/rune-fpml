package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxOptionStrikePrice;
import fpml.confirmation.validation.FxOptionStrikePriceTypeFormatValidator;
import fpml.confirmation.validation.FxOptionStrikePriceValidator;
import fpml.confirmation.validation.exists.FxOptionStrikePriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxOptionStrikePrice.class)
public class FxOptionStrikePriceMeta implements RosettaMetaData<FxOptionStrikePrice> {

	@Override
	public List<Validator<? super FxOptionStrikePrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxOptionStrikePrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxOptionStrikePrice> validator() {
		return new FxOptionStrikePriceValidator();
	}

	@Override
	public Validator<? super FxOptionStrikePrice> typeFormatValidator() {
		return new FxOptionStrikePriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxOptionStrikePrice, Set<String>> onlyExistsValidator() {
		return new FxOptionStrikePriceOnlyExistsValidator();
	}
}
