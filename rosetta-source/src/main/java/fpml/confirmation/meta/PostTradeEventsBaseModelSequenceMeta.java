package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PostTradeEventsBaseModelSequence;
import fpml.confirmation.validation.PostTradeEventsBaseModelSequenceTypeFormatValidator;
import fpml.confirmation.validation.PostTradeEventsBaseModelSequenceValidator;
import fpml.confirmation.validation.exists.PostTradeEventsBaseModelSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PostTradeEventsBaseModelSequence.class)
public class PostTradeEventsBaseModelSequenceMeta implements RosettaMetaData<PostTradeEventsBaseModelSequence> {

	@Override
	public List<Validator<? super PostTradeEventsBaseModelSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PostTradeEventsBaseModelSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PostTradeEventsBaseModelSequence> validator() {
		return new PostTradeEventsBaseModelSequenceValidator();
	}

	@Override
	public Validator<? super PostTradeEventsBaseModelSequence> typeFormatValidator() {
		return new PostTradeEventsBaseModelSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PostTradeEventsBaseModelSequence, Set<String>> onlyExistsValidator() {
		return new PostTradeEventsBaseModelSequenceOnlyExistsValidator();
	}
}
