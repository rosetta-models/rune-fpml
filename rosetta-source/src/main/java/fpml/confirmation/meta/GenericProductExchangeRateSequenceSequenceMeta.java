package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GenericProductExchangeRateSequenceSequence;
import fpml.confirmation.validation.GenericProductExchangeRateSequenceSequenceTypeFormatValidator;
import fpml.confirmation.validation.GenericProductExchangeRateSequenceSequenceValidator;
import fpml.confirmation.validation.exists.GenericProductExchangeRateSequenceSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=GenericProductExchangeRateSequenceSequence.class)
public class GenericProductExchangeRateSequenceSequenceMeta implements RosettaMetaData<GenericProductExchangeRateSequenceSequence> {

	@Override
	public List<Validator<? super GenericProductExchangeRateSequenceSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericProductExchangeRateSequenceSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GenericProductExchangeRateSequenceSequence> validator() {
		return new GenericProductExchangeRateSequenceSequenceValidator();
	}

	@Override
	public Validator<? super GenericProductExchangeRateSequenceSequence> typeFormatValidator() {
		return new GenericProductExchangeRateSequenceSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericProductExchangeRateSequenceSequence, Set<String>> onlyExistsValidator() {
		return new GenericProductExchangeRateSequenceSequenceOnlyExistsValidator();
	}
}
