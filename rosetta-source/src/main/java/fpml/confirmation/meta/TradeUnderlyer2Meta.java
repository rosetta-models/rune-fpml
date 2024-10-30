package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeUnderlyer2;
import fpml.confirmation.validation.TradeUnderlyer2TypeFormatValidator;
import fpml.confirmation.validation.TradeUnderlyer2Validator;
import fpml.confirmation.validation.exists.TradeUnderlyer2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeUnderlyer2.class)
public class TradeUnderlyer2Meta implements RosettaMetaData<TradeUnderlyer2> {

	@Override
	public List<Validator<? super TradeUnderlyer2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TradeUnderlyer2>create(fpml.confirmation.validation.datarule.TradeUnderlyer2Choice0.class),
			factory.<fpml.confirmation.TradeUnderlyer2>create(fpml.confirmation.validation.datarule.TradeUnderlyer2Choice1.class)
		);
	}
	
	@Override
	public List<Function<? super TradeUnderlyer2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeUnderlyer2> validator() {
		return new TradeUnderlyer2Validator();
	}

	@Override
	public Validator<? super TradeUnderlyer2> typeFormatValidator() {
		return new TradeUnderlyer2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeUnderlyer2, Set<String>> onlyExistsValidator() {
		return new TradeUnderlyer2OnlyExistsValidator();
	}
}
