package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GenericProductExchangeRateSequence;
import fpml.confirmation.validation.GenericProductExchangeRateSequenceTypeFormatValidator;
import fpml.confirmation.validation.GenericProductExchangeRateSequenceValidator;
import fpml.confirmation.validation.exists.GenericProductExchangeRateSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GenericProductExchangeRateSequence.class)
public class GenericProductExchangeRateSequenceMeta implements RosettaMetaData<GenericProductExchangeRateSequence> {

	@Override
	public List<Validator<? super GenericProductExchangeRateSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericProductExchangeRateSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GenericProductExchangeRateSequence> validator() {
		return new GenericProductExchangeRateSequenceValidator();
	}

	@Override
	public Validator<? super GenericProductExchangeRateSequence> typeFormatValidator() {
		return new GenericProductExchangeRateSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericProductExchangeRateSequence, Set<String>> onlyExistsValidator() {
		return new GenericProductExchangeRateSequenceOnlyExistsValidator();
	}
}
