package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeNotionalChangeModelSequence0;
import fpml.confirmation.validation.TradeNotionalChangeModelSequence0TypeFormatValidator;
import fpml.confirmation.validation.TradeNotionalChangeModelSequence0Validator;
import fpml.confirmation.validation.exists.TradeNotionalChangeModelSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeNotionalChangeModelSequence0.class)
public class TradeNotionalChangeModelSequence0Meta implements RosettaMetaData<TradeNotionalChangeModelSequence0> {

	@Override
	public List<Validator<? super TradeNotionalChangeModelSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeNotionalChangeModelSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeNotionalChangeModelSequence0> validator() {
		return new TradeNotionalChangeModelSequence0Validator();
	}

	@Override
	public Validator<? super TradeNotionalChangeModelSequence0> typeFormatValidator() {
		return new TradeNotionalChangeModelSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeNotionalChangeModelSequence0, Set<String>> onlyExistsValidator() {
		return new TradeNotionalChangeModelSequence0OnlyExistsValidator();
	}
}
