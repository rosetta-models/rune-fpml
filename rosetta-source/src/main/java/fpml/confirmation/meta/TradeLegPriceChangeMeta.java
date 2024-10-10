package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeLegPriceChange;
import fpml.confirmation.validation.TradeLegPriceChangeTypeFormatValidator;
import fpml.confirmation.validation.TradeLegPriceChangeValidator;
import fpml.confirmation.validation.exists.TradeLegPriceChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeLegPriceChange.class)
public class TradeLegPriceChangeMeta implements RosettaMetaData<TradeLegPriceChange> {

	@Override
	public List<Validator<? super TradeLegPriceChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TradeLegPriceChange>create(fpml.confirmation.validation.datarule.TradeLegPriceChangeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeLegPriceChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeLegPriceChange> validator() {
		return new TradeLegPriceChangeValidator();
	}

	@Override
	public Validator<? super TradeLegPriceChange> typeFormatValidator() {
		return new TradeLegPriceChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeLegPriceChange, Set<String>> onlyExistsValidator() {
		return new TradeLegPriceChangeOnlyExistsValidator();
	}
}
