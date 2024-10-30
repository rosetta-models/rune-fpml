package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExchangeRateSequenceSequence;
import fpml.confirmation.validation.ExchangeRateSequenceSequenceTypeFormatValidator;
import fpml.confirmation.validation.ExchangeRateSequenceSequenceValidator;
import fpml.confirmation.validation.exists.ExchangeRateSequenceSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ExchangeRateSequenceSequence.class)
public class ExchangeRateSequenceSequenceMeta implements RosettaMetaData<ExchangeRateSequenceSequence> {

	@Override
	public List<Validator<? super ExchangeRateSequenceSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExchangeRateSequenceSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExchangeRateSequenceSequence> validator() {
		return new ExchangeRateSequenceSequenceValidator();
	}

	@Override
	public Validator<? super ExchangeRateSequenceSequence> typeFormatValidator() {
		return new ExchangeRateSequenceSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExchangeRateSequenceSequence, Set<String>> onlyExistsValidator() {
		return new ExchangeRateSequenceSequenceOnlyExistsValidator();
	}
}
