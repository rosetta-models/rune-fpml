package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InstrumentSetSequence;
import fpml.confirmation.validation.InstrumentSetSequenceTypeFormatValidator;
import fpml.confirmation.validation.InstrumentSetSequenceValidator;
import fpml.confirmation.validation.exists.InstrumentSetSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=InstrumentSetSequence.class)
public class InstrumentSetSequenceMeta implements RosettaMetaData<InstrumentSetSequence> {

	@Override
	public List<Validator<? super InstrumentSetSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.InstrumentSetSequence>create(fpml.confirmation.validation.datarule.InstrumentSetSequenceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super InstrumentSetSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InstrumentSetSequence> validator() {
		return new InstrumentSetSequenceValidator();
	}

	@Override
	public Validator<? super InstrumentSetSequence> typeFormatValidator() {
		return new InstrumentSetSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InstrumentSetSequence, Set<String>> onlyExistsValidator() {
		return new InstrumentSetSequenceOnlyExistsValidator();
	}
}
