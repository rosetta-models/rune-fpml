package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradingEventsBaseModelSequence;
import fpml.confirmation.validation.TradingEventsBaseModelSequenceTypeFormatValidator;
import fpml.confirmation.validation.TradingEventsBaseModelSequenceValidator;
import fpml.confirmation.validation.exists.TradingEventsBaseModelSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradingEventsBaseModelSequence.class)
public class TradingEventsBaseModelSequenceMeta implements RosettaMetaData<TradingEventsBaseModelSequence> {

	@Override
	public List<Validator<? super TradingEventsBaseModelSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradingEventsBaseModelSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradingEventsBaseModelSequence> validator() {
		return new TradingEventsBaseModelSequenceValidator();
	}

	@Override
	public Validator<? super TradingEventsBaseModelSequence> typeFormatValidator() {
		return new TradingEventsBaseModelSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradingEventsBaseModelSequence, Set<String>> onlyExistsValidator() {
		return new TradingEventsBaseModelSequenceOnlyExistsValidator();
	}
}
