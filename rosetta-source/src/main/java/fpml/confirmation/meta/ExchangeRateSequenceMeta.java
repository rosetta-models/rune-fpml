package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExchangeRateSequence;
import fpml.confirmation.validation.ExchangeRateSequenceTypeFormatValidator;
import fpml.confirmation.validation.ExchangeRateSequenceValidator;
import fpml.confirmation.validation.exists.ExchangeRateSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ExchangeRateSequence.class)
public class ExchangeRateSequenceMeta implements RosettaMetaData<ExchangeRateSequence> {

	@Override
	public List<Validator<? super ExchangeRateSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExchangeRateSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExchangeRateSequence> validator() {
		return new ExchangeRateSequenceValidator();
	}

	@Override
	public Validator<? super ExchangeRateSequence> typeFormatValidator() {
		return new ExchangeRateSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExchangeRateSequence, Set<String>> onlyExistsValidator() {
		return new ExchangeRateSequenceOnlyExistsValidator();
	}
}
