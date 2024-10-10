package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PriceQuoteUnits;
import fpml.confirmation.validation.PriceQuoteUnitsTypeFormatValidator;
import fpml.confirmation.validation.PriceQuoteUnitsValidator;
import fpml.confirmation.validation.exists.PriceQuoteUnitsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PriceQuoteUnits.class)
public class PriceQuoteUnitsMeta implements RosettaMetaData<PriceQuoteUnits> {

	@Override
	public List<Validator<? super PriceQuoteUnits>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PriceQuoteUnits, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PriceQuoteUnits> validator() {
		return new PriceQuoteUnitsValidator();
	}

	@Override
	public Validator<? super PriceQuoteUnits> typeFormatValidator() {
		return new PriceQuoteUnitsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PriceQuoteUnits, Set<String>> onlyExistsValidator() {
		return new PriceQuoteUnitsOnlyExistsValidator();
	}
}
