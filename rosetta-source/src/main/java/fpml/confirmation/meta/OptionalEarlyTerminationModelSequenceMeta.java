package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionalEarlyTerminationModelSequence;
import fpml.confirmation.validation.OptionalEarlyTerminationModelSequenceTypeFormatValidator;
import fpml.confirmation.validation.OptionalEarlyTerminationModelSequenceValidator;
import fpml.confirmation.validation.exists.OptionalEarlyTerminationModelSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OptionalEarlyTerminationModelSequence.class)
public class OptionalEarlyTerminationModelSequenceMeta implements RosettaMetaData<OptionalEarlyTerminationModelSequence> {

	@Override
	public List<Validator<? super OptionalEarlyTerminationModelSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionalEarlyTerminationModelSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionalEarlyTerminationModelSequence> validator() {
		return new OptionalEarlyTerminationModelSequenceValidator();
	}

	@Override
	public Validator<? super OptionalEarlyTerminationModelSequence> typeFormatValidator() {
		return new OptionalEarlyTerminationModelSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionalEarlyTerminationModelSequence, Set<String>> onlyExistsValidator() {
		return new OptionalEarlyTerminationModelSequenceOnlyExistsValidator();
	}
}
