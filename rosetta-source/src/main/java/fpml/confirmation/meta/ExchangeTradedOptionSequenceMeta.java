package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExchangeTradedOptionSequence;
import fpml.confirmation.validation.ExchangeTradedOptionSequenceTypeFormatValidator;
import fpml.confirmation.validation.ExchangeTradedOptionSequenceValidator;
import fpml.confirmation.validation.exists.ExchangeTradedOptionSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ExchangeTradedOptionSequence.class)
public class ExchangeTradedOptionSequenceMeta implements RosettaMetaData<ExchangeTradedOptionSequence> {

	@Override
	public List<Validator<? super ExchangeTradedOptionSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExchangeTradedOptionSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExchangeTradedOptionSequence> validator() {
		return new ExchangeTradedOptionSequenceValidator();
	}

	@Override
	public Validator<? super ExchangeTradedOptionSequence> typeFormatValidator() {
		return new ExchangeTradedOptionSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExchangeTradedOptionSequence, Set<String>> onlyExistsValidator() {
		return new ExchangeTradedOptionSequenceOnlyExistsValidator();
	}
}
