package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeNotionalChangeModelSequence1;
import fpml.confirmation.validation.TradeNotionalChangeModelSequence1TypeFormatValidator;
import fpml.confirmation.validation.TradeNotionalChangeModelSequence1Validator;
import fpml.confirmation.validation.exists.TradeNotionalChangeModelSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeNotionalChangeModelSequence1.class)
public class TradeNotionalChangeModelSequence1Meta implements RosettaMetaData<TradeNotionalChangeModelSequence1> {

	@Override
	public List<Validator<? super TradeNotionalChangeModelSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeNotionalChangeModelSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeNotionalChangeModelSequence1> validator() {
		return new TradeNotionalChangeModelSequence1Validator();
	}

	@Override
	public Validator<? super TradeNotionalChangeModelSequence1> typeFormatValidator() {
		return new TradeNotionalChangeModelSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeNotionalChangeModelSequence1, Set<String>> onlyExistsValidator() {
		return new TradeNotionalChangeModelSequence1OnlyExistsValidator();
	}
}
