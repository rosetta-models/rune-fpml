package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeOrInfoModelSequence;
import fpml.confirmation.validation.TradeOrInfoModelSequenceTypeFormatValidator;
import fpml.confirmation.validation.TradeOrInfoModelSequenceValidator;
import fpml.confirmation.validation.exists.TradeOrInfoModelSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeOrInfoModelSequence.class)
public class TradeOrInfoModelSequenceMeta implements RosettaMetaData<TradeOrInfoModelSequence> {

	@Override
	public List<Validator<? super TradeOrInfoModelSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeOrInfoModelSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeOrInfoModelSequence> validator() {
		return new TradeOrInfoModelSequenceValidator();
	}

	@Override
	public Validator<? super TradeOrInfoModelSequence> typeFormatValidator() {
		return new TradeOrInfoModelSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeOrInfoModelSequence, Set<String>> onlyExistsValidator() {
		return new TradeOrInfoModelSequenceOnlyExistsValidator();
	}
}
