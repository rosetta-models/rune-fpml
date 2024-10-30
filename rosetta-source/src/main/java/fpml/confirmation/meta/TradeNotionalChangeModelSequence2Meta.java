package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeNotionalChangeModelSequence2;
import fpml.confirmation.validation.TradeNotionalChangeModelSequence2TypeFormatValidator;
import fpml.confirmation.validation.TradeNotionalChangeModelSequence2Validator;
import fpml.confirmation.validation.exists.TradeNotionalChangeModelSequence2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeNotionalChangeModelSequence2.class)
public class TradeNotionalChangeModelSequence2Meta implements RosettaMetaData<TradeNotionalChangeModelSequence2> {

	@Override
	public List<Validator<? super TradeNotionalChangeModelSequence2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeNotionalChangeModelSequence2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeNotionalChangeModelSequence2> validator() {
		return new TradeNotionalChangeModelSequence2Validator();
	}

	@Override
	public Validator<? super TradeNotionalChangeModelSequence2> typeFormatValidator() {
		return new TradeNotionalChangeModelSequence2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeNotionalChangeModelSequence2, Set<String>> onlyExistsValidator() {
		return new TradeNotionalChangeModelSequence2OnlyExistsValidator();
	}
}
