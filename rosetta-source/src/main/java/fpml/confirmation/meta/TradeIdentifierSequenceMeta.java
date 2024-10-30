package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeIdentifierSequence;
import fpml.confirmation.validation.TradeIdentifierSequenceTypeFormatValidator;
import fpml.confirmation.validation.TradeIdentifierSequenceValidator;
import fpml.confirmation.validation.exists.TradeIdentifierSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeIdentifierSequence.class)
public class TradeIdentifierSequenceMeta implements RosettaMetaData<TradeIdentifierSequence> {

	@Override
	public List<Validator<? super TradeIdentifierSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeIdentifierSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeIdentifierSequence> validator() {
		return new TradeIdentifierSequenceValidator();
	}

	@Override
	public Validator<? super TradeIdentifierSequence> typeFormatValidator() {
		return new TradeIdentifierSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeIdentifierSequence, Set<String>> onlyExistsValidator() {
		return new TradeIdentifierSequenceOnlyExistsValidator();
	}
}
